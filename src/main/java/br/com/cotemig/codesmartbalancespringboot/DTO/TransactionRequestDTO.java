package br.com.cotemig.codesmartbalancespringboot.DTO;

import jakarta.validation.constraints.NotNull;
import br.com.cotemig.codesmartbalancespringboot.Model.TransactionType;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionRequestDTO (
        @NotNull(message = "Descrição não pode ser nula.")
        String description,
        @NotNull(message = "Tipo não pode ser nulo.")
        TransactionType type,
        @NotNull(message = "Valor não pode ser nulo.")
        @PositiveOrZero(message = "O valor deve ser maior que zero")
        BigDecimal amount,
        @NotNull(message = "Data da transação não pode ser nula.")
        LocalDate occurredAt,
        @NotNull(message = "Banco não pode ser nulo.")
        Long bankId) {
}
