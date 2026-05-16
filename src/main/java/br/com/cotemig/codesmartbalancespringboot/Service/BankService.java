package br.com.cotemig.codesmartbalancespringboot.Service;

import br.com.cotemig.codesmartbalancespringboot.Exception.NotFoundException;
import br.com.cotemig.codesmartbalancespringboot.Model.Bank;
import br.com.cotemig.codesmartbalancespringboot.Repository.BankRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class BankService {
    private BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> findAll() {
        return this.bankRepository.findAll();
    }

    public Bank findById(Long id) throws NotFoundException {
        var bank = this.bankRepository.findById(id);
        if (bank.isEmpty()) throw new NotFoundException();
        return bank.get();
    }

    public void deleteById(Long id) throws NotFoundException {
        var bank = findById(id);
        this.bankRepository.delete(bank);
    }

    public Bank save(Bank bank) {
        this.bankRepository.save(bank);
        return bank;
    }
}
