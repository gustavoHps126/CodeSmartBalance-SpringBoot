package br.com.cotemig.codesmartbalancespringboot.model;


import jakarta.persistence.*;
import jakarta.validation.ValidationException;

import java.util.Objects;

@Entity
@Table
public class User extends Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100,unique = false)
    private String name;

    @Column(nullable = false,length = 100,unique = true)
    private  String username;

    @Column(nullable = false,length = 100,unique = false)
    private String password;

    @Column(nullable = false,length = 10)
    private boolean admin;

    public void merge(UserDTO user) {
        this.setId(user.id());
        this.setName(user.name());
        this.setUsername(user.username());
        if (!user.password().isBlank()) {
            this.setPassword(PasswordUtil.hash(user.password()));
        }
        this.setAdmin(user.admin());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public void validade() throws ValidationException {
        if (this.getName() == null) throw new ValidationException("Nome não pode ser nulo.");
        if (this.getUsername() == null) throw new ValidationException("Nome do usuário não pode ser nulo.");
        if (this.getPassword() == null) throw new ValidationException("Senha não pode ser nula.");
        if (this.getAdmin() == null) throw new ValidationException("Senha não pode ser nula.");
    }
}
