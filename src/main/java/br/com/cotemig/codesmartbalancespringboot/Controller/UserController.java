package br.com.cotemig.codesmartbalancespringboot.Controller;

import br.com.cotemig.codesmartbalancespringboot.DTO.ErrorResponseDTO;
import br.com.cotemig.codesmartbalancespringboot.DTO.UserRequestDTO;
import br.com.cotemig.codesmartbalancespringboot.Exception.NotFoundException;
import br.com.cotemig.codesmartbalancespringboot.Mapper.UserMapper;
import br.com.cotemig.codesmartbalancespringboot.Model.User;
import br.com.cotemig.codesmartbalancespringboot.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws NotFoundException {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid UserRequestDTO userDTO) {
        var user = userMapper.createUser(userDTO);
        user = userService.save(user);
        return ResponseEntity.status(201).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid UserRequestDTO userRequestDTO) throws NotFoundException {
        var user = userService.findById(id);
        user = userMapper.updateUser(userRequestDTO, user);
        user = userService.save(user);
        return ResponseEntity.ok(user);
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
                new ErrorResponseDTO("Não pode haver mais de um usuário com o mesmo username!", new String[0])
        );
    }
}
