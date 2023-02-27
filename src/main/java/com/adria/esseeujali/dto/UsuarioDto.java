package com.adria.esseeujali.dto;


import com.adria.esseeujali.model.Role;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


public class UsuarioDto {

    private Integer id;

    String nome;

    String email;

    String senha;
    @CreationTimestamp
    @Column(name = "data_cadastro", nullable = false, updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDate dataCadastro;

//    private List<Role> roles;

    public UsuarioDto() {
    }

    public UsuarioDto(Integer id,String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioDto(Integer id, String nome, String email, String senha, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDto that = (UsuarioDto) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(email, that.email) && Objects.equals(senha, that.senha) && Objects.equals(dataCadastro, that.dataCadastro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, senha, dataCadastro);
    }
}

