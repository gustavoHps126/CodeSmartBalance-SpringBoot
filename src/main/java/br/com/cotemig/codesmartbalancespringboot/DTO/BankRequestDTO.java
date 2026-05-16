package br.com.cotemig.codesmartbalancespringboot.DTO;

import jakarta.validation.ValidationException;
import jakarta.validation.constraints.NotNull;

public record BankRequestDTO(
        @NotNull(message = "Código não pode ser nulo.")
        String code,
        @NotNull(message = "Nome não pode ser nulo.")
        String name,
        @NotNull(message = "Logo não pode ser nula.")
        String logoUrl,
        @NotNull(message = "Id do usuário não pode ser nulo.")
        Long userId) {
}
