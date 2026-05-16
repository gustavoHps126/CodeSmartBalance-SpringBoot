package br.com.cotemig.codesmartbalancespringboot.Service;

import br.com.cotemig.codesmartbalancespringboot.Exception.NotFoundException;
import br.com.cotemig.codesmartbalancespringboot.Model.Bank;
import br.com.cotemig.codesmartbalancespringboot.Repository.BankRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    public Bank findById(Long id) throws NotFoundException {
        return bankRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(Long id) throws NotFoundException {
        var bank = findById(id);
        bankRepository.delete(bank);
    }

    public Bank save(Bank bank) {
        return bankRepository.save(bank);
    }
}
