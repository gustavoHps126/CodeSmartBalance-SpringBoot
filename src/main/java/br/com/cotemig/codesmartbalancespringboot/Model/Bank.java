package br.com.cotemig.codesmartbalancespringboot.Model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10, unique = true)
    private String code;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @Column(nullable = false, length = 300)
    private String logoUrl;

    @Column(nullable = false)
    private Long userId;

    public Bank() {}

    public Bank(String code, String name, String logoUrl, Long userId) {
        this.code = code;
        this.name = name;
        this.logoUrl = logoUrl;
        this.userId = userId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLogoUrl() { return logoUrl; }
    public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(id, bank.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
