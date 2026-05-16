package br.com.cotemig.codesmartbalancespringboot.Service;

import br.com.cotemig.codesmartbalancespringboot.Exception.NotFoundException;
import br.com.cotemig.codesmartbalancespringboot.Model.User;
import br.com.cotemig.codesmartbalancespringboot.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(Long id) throws NotFoundException {
        var user = this.userRepository.findById(id);
        if (user.isEmpty()) throw new NotFoundException();
        return user.get();
    }

    public void deleteById(Long id) throws NotFoundException {
        var user = findById(id);
        this.userRepository.delete(user);
    }

    public User save(User user) {
        this.userRepository.save(user);
        return user;
    }
}
