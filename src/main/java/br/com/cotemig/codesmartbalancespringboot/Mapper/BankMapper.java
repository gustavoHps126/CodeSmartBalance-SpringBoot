package br.com.cotemig.codesmartbalancespringboot.Mapper;

import br.com.cotemig.codesmartbalancespringboot.DTO.BankRequestDTO;
import br.com.cotemig.codesmartbalancespringboot.Model.Bank;
import org.springframework.stereotype.Component;

@Component
public class BankMapper {

    public Bank createBank(BankRequestDTO dto) {
        return new Bank(dto.code(), dto.name(), dto.logoUrl(), dto.userId());
    }

    public Bank updateBank(BankRequestDTO dto, Bank bank) {
        bank.setCode(dto.code());
        bank.setName(dto.name());
        bank.setLogoUrl(dto.logoUrl());
        bank.setUserId(dto.userId());
        return bank;
    }
}
