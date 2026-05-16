package br.com.cotemig.codesmartbalancespringboot.Service;

import br.com.cotemig.codesmartbalancespringboot.Exception.NotFoundException;
import br.com.cotemig.codesmartbalancespringboot.Model.Transaction;
import br.com.cotemig.codesmartbalancespringboot.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll() {
        return this.transactionRepository.findAll();
    }

    public Transaction findById(Long id) throws NotFoundException {
        var transaction = this.transactionRepository.findById(id);
        if (transaction.isEmpty()) throw new NotFoundException();
        return transaction.get();
    }

    public void deleteById(Long id) throws NotFoundException {
        var transaction = findById(id);
        this.transactionRepository.delete(transaction);
    }

    public Transaction save(Transaction transaction) {
        this.transactionRepository.save(transaction);
        return transaction;
    }
}
