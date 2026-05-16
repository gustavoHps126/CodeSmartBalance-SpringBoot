package br.com.cotemig.codesmartbalancespringboot.Controller;

import br.com.cotemig.codesmartbalancespringboot.DTO.ErrorResponseDTO;
import br.com.cotemig.codesmartbalancespringboot.DTO.TransactionRequestDTO;
import br.com.cotemig.codesmartbalancespringboot.Exception.NotFoundException;
import br.com.cotemig.codesmartbalancespringboot.Mapper.TransactionMapper;
import br.com.cotemig.codesmartbalancespringboot.Model.Transaction;
import br.com.cotemig.codesmartbalancespringboot.Service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    public TransactionController(TransactionService transactionService, TransactionMapper transactionMapper) {
        this.transactionService = transactionService;
        this.transactionMapper = transactionMapper;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> findAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(transactionService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws NotFoundException {
        transactionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody @Valid TransactionRequestDTO transactionDTO) {
        var transaction = transactionMapper.createTransaction(transactionDTO);
        transaction = transactionService.save(transaction);
        return ResponseEntity.status(201).body(transaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update(@PathVariable Long id, @RequestBody @Valid TransactionRequestDTO transactionRequestDTO) throws NotFoundException {
        var transaction = transactionService.findById(id);
        transaction = transactionMapper.updateTransaction(transactionRequestDTO, transaction);
        transaction = transactionService.save(transaction);
        return ResponseEntity.ok(transaction);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Void> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String[] details = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toArray(String[]::new);
        return ResponseEntity.status(400).body(new ErrorResponseDTO("Houveram campos inválidos!", details));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return ResponseEntity.status(409).body(
                new ErrorResponseDTO("Violação de integridade de dados!", new String[0])
        );
    }
}
