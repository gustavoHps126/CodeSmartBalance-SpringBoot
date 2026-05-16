package br.com.cotemig.codesmartbalancespringboot.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "banks")
public class Bank{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(nullable = false,length = 50, unique = true)
    private String name;

    @Column(nullable = false, length = 300)
    private String logoUrl;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    public Bank(){

    }

    public Bank(Long code, String name, String logoUrl, Long userID) {
        this.code = code;
        this.name = name;
        this.logoUrl = logoUrl;
        this.userID = userID;
    }

    public void merge(BankDTO bankDTO) {
        this.setId(bankDTO.id());
        this.setCode(bankDTO.code());
        this.setName(bankDTO.name());
        this.setLogoUrl(bankDTO.logoUrl());
    }

    public Long getCode(){return code;}
    public void setCode(Long code) {this.code = code;}

    public String getName(){return  name;}
    public void setName(String name){this.name = name;}

    public String getLogoUrl(){return logoUrl;}
    public void setLogoUrl(String logoUrl){this.logoUrl = logoUrl;}

    public Long getUserID(){return userID;}
    public void setUserID(Long userID){this.userID = userID;}

    @Override
    public  boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(code, bank.code);
    }

    @Override
    public int hashCode(){return Objects.hash(code);}

}
