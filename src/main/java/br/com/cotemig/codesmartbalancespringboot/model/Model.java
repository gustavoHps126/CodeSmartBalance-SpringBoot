package br.com.cotemig.codesmartbalancespringboot.model;

import jakarta.validation.ValidationException;

public abstract class Model {
    private Long id;
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public abstract void  validade()throws ValidationException;
}
