package com.adria.esseeujali.dto;

import java.util.Objects;

public class MeusTitulosDto {

    private Integer idLivro;
    private String titulo;

    public MeusTitulosDto(Integer idLivro, String titulo) {
        this.idLivro = idLivro;
        this.titulo = titulo;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeusTitulosDto that = (MeusTitulosDto) o;
        return Objects.equals(idLivro, that.idLivro) && Objects.equals(titulo, that.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLivro, titulo);
    }
}

