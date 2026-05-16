package br.com.cotemig.codesmartbalancespringboot.Service;

import br.com.cotemig.codesmartbalancespringboot.Model.Bank;
import br.com.cotemig.codesmartbalancespringboot.Model.Transaction;
import br.com.cotemig.codesmartbalancespringboot.Model.TransactionType;
import br.com.cotemig.codesmartbalancespringboot.Model.User;
import br.com.cotemig.codesmartbalancespringboot.Repository.BankRepository;
import br.com.cotemig.codesmartbalancespringboot.Repository.TransactionRepository;
import br.com.cotemig.codesmartbalancespringboot.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class SeedService {

    private final BankRepository bankRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    private final Logger logger = LoggerFactory.getLogger(SeedService.class);

    public SeedService(BankRepository bankRepository, UserRepository userRepository, TransactionRepository transactionRepository) {
        this.bankRepository = bankRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    public void doSeed() {
        if (userRepository.count() == 0) {
            for (int i = 1; i <= 3; i++) {
                User u = new User("Usuario " + i, "user" + i, "senha" + i, false);
                userRepository.save(u);
            }
            logger.info("A tabela users foi populada com sucesso!");
        } else {
            logger.info("A tabela users já se encontra populada!");
        }

        if (bankRepository.count() == 0) {
            long userId = userRepository.findAll().get(0).getId();
            String[] codes = {"001", "237", "341"};
            String[] names = {"Banco do Brasil", "Bradesco", "Itaú"};
            for (int i = 0; i < 3; i++) {
                Bank b = new Bank(codes[i], names[i], "https://logo.example.com/" + codes[i] + ".png", userId);
                bankRepository.save(b);
            }
            logger.info("A tabela banks foi populada com sucesso!");
        } else {
            logger.info("A tabela banks já se encontra populada!");
        }

        if (transactionRepository.count() == 0) {
            long bankId = bankRepository.findAll().get(0).getId();
            for (int i = 1; i <= 3; i++) {
                Transaction t = new Transaction(
                        "Transação de exemplo " + i,
                        i % 2 == 0 ? TransactionType.DEBIT : TransactionType.CREDIT,
                        new BigDecimal("1000.00").multiply(new BigDecimal(i)),
                        LocalDate.now(),
                        bankId
                );
                transactionRepository.save(t);
            }
            logger.info("A tabela transactions foi populada com sucesso!");
        } else {
            logger.info("A tabela transactions já se encontra populada!");
        }
    }
}
