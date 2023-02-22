package com.adria.esseeujali.dto;


import java.time.LocalDate;


public class UsuarioDto {
    private Long id;
    private String email;
    private String senha;

    public UsuarioDto() {

    }

    public UsuarioDto(Long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
