package br.com.cotemig.codesmartbalancespringboot.DTO;

import br.com.cotemig.codesmartbalancespringboot.Component.Pagination;
import br.com.cotemig.codesmartbalancespringboot.Model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public record TransactionsPaginationDTO(List<Transaction> transactions, Pagination pagination, BigDecimal credit,
                                        BigDecimal debit) {
}
