package br.com.cotemig.codesmartbalancespringboot.Repository;

import br.com.cotemig.codesmartbalancespringboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

