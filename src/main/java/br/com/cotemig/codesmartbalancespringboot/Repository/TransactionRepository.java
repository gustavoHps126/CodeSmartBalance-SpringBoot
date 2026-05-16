package br.com.cotemig.codesmartbalancespringboot.Repository;

import br.com.cotemig.codesmartbalancespringboot.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

