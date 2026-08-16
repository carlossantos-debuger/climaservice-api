package com.climaservice.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.jspecify.annotations.Nullable;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false, length = 150)
    private String nome;

    @Column(name = "cpf_cnpj", length = 14)
    private String cpfCnpj;

    @Column(length = 20)
    private String telefone;

    @Column(length = 150)
    private String email;


    public Cliente() {

    }

    public Cliente(String nome, String cpfCnpj, String telefone, String email) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}