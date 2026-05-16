package br.com.cotemig.codesmartbalancespringboot.Mapper;

import br.com.cotemig.codesmartbalancespringboot.DTO.BankRequestDTO;
import br.com.cotemig.codesmartbalancespringboot.Model.Bank;
import org.springframework.stereotype.Component;

@Component
public class BankMapper {

    public Bank createBank(BankRequestDTO bankRequestDTO) {
        return new Bank(
                bankRequestDTO.name(),
                bankRequestDTO.logoUrl(),
                bankRequestDTO.userId()
        );
    }

    public Bank updateBank(BankRequestDTO bankRequestDTO, Bank bank) {
        bank.setName(bankRequestDTO.name());
        bank.setLogoUrl(bankRequestDTO.logoUrl());
        bank.setUserID(bankRequestDTO.userId());
        return bank;
    }

}