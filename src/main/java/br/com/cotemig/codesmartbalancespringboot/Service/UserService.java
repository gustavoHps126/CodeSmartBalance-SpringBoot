package br.com.cotemig.codesmartbalancespringboot.Service;

import br.com.cotemig.codesmartbalancespringboot.Exception.NotFoundException;
import br.com.cotemig.codesmartbalancespringboot.Model.User;
import br.com.cotemig.codesmartbalancespringboot.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(Long id) throws NotFoundException {
        var user = findById(id);
        userRepository.delete(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
