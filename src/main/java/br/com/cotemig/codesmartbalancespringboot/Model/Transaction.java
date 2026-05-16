package br.com.cotemig.codesmartbalancespringboot.Model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "transactions")
public class Transaction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 500, unique = false)
    private String description;

    @Column(nullable = false,length = 100)
    private TransactionType type;

    @Column(nullable = false,length = 100)
    private BigDecimal amount;


    @Column(nullable = false,length = 100)
    private LocalDate occurredAt;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bankId;

    public Transaction(){

    }

    public Transaction(Long id, String description, TransactionType type, BigDecimal amount, LocalDate occurredAt, Long bankId) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.occurredAt = occurredAt;
        this.bankId = bankId;
    }

    public void merge(TransactionDTO transactionDTO) {
        this.setId(transactionDTO.id());
        this.setDescription(transactionDTO.description());
        this.setAmount(transactionDTO.amount());
        this.setType(transactionDTO.type());
        this.setOccurredAt(transactionDTO.occurredAt());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(LocalDate occurredAt) {
        this.occurredAt = occurredAt;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}


