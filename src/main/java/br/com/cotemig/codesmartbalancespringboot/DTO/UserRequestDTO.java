package br.com.cotemig.codesmartbalancespringboot.DTO;

import jakarta.validation.ValidationException;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO (
        @NotNull(message = "Nome não pode ser nulo.")
        String name,
        @NotNull(message = "Nome do usuário não pode ser nulo.")
        String username,
        @NotNull(message = "Senha não pode ser nula.")
        String password,
        @NotNull(message = "O tipo de usuario não pode ser nulo.")
        Boolean admin) {
}
