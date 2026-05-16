package br.com.cotemig.codesmartbalancespringboot.DTO;

import br.com.cotemig.codesmartbalancespringboot.Component.Pagination;
import br.com.cotemig.codesmartbalancespringboot.Model.Bank;

import java.util.List;

public record BanksPaginationDTO(List<Bank> banks, Pagination pagination) {
}
