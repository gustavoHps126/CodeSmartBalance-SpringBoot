package br.com.cotemig.codesmartbalancespringboot.Mapper;

import br.com.cotemig.codesmartbalancespringboot.DTO.UserRequestDTO;
import br.com.cotemig.codesmartbalancespringboot.Model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User createUser(UserRequestDTO userRequestDTO) {
        return new User(
                userRequestDTO.name(),
                userRequestDTO.username(),
                userRequestDTO.password(),
                userRequestDTO.admin()
        );
    }

    public User updateUser(UserRequestDTO userRequestDTO, User user) {
        user.setName(userRequestDTO.name());
        user.setUsername(userRequestDTO.username());
        user.setPassword(userRequestDTO.password());
        user.setAdmin(userRequestDTO.admin());
        return user;
    }

}