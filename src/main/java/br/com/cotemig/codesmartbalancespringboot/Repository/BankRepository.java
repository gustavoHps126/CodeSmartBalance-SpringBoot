package br.com.cotemig.codesmartbalancespringboot.Repository;


import br.com.cotemig.codesmartbalancespringboot.Model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
