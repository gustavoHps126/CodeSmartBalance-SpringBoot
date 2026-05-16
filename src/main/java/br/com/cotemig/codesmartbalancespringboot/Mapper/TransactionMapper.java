package br.com.cotemig.codesmartbalancespringboot.Mapper;

import br.com.cotemig.codesmartbalancespringboot.DTO.TransactionRequestDTO;
import br.com.cotemig.codesmartbalancespringboot.Model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public Transaction createTransaction(TransactionRequestDTO transactionRequestDTO) {
        return new Transaction(
                transactionRequestDTO.description(),
                transactionRequestDTO.type(),
                transactionRequestDTO.amount(),
                transactionRequestDTO.occurredAt(),
                transactionRequestDTO.bankId()
        );
    }

    public Transaction updateTransaction(TransactionRequestDTO transactionRequestDTO, Transaction transaction) {
        transaction.setDescription(transactionRequestDTO.description());
        transaction.setType(transactionRequestDTO.type());
        transaction.setAmount(transactionRequestDTO.amount());
        transaction.setOccurredAt(transactionRequestDTO.occurredAt());
        transaction.setBankId(transactionRequestDTO.bankId());
        return transaction;
    }

}