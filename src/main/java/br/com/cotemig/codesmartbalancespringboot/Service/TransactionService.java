package br.com.cotemig.codesmartbalancespringboot.Service;

import br.com.cotemig.codesmartbalancespringboot.Exception.NotFoundException;
import br.com.cotemig.codesmartbalancespringboot.Model.Transaction;
import br.com.cotemig.codesmartbalancespringboot.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(Long id) throws NotFoundException {
        return transactionRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(Long id) throws NotFoundException {
        var transaction = findById(id);
        transactionRepository.delete(transaction);
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
