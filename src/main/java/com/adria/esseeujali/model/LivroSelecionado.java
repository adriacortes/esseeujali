package com.adria.esseeujali.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LivroSelecionado implements Serializable {

    private int idUsuario;
    private int idLivro;

    public LivroSelecionado() {

    }
    public LivroSelecionado(int idUsuario, int idLivro) {
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivroSelecionado that = (LivroSelecionado) o;
        return idUsuario == that.idUsuario && idLivro == that.idLivro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idLivro);
    }
}

