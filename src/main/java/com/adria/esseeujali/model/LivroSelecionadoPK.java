package com.adria.esseeujali.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LivroSelecionadoPK implements Serializable {

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "livro_id")
    private Integer livroId;

    public LivroSelecionadoPK() {
    }

    public LivroSelecionadoPK(Integer usuarioId, Integer livroId) {
        this.usuarioId = usuarioId;
        this.livroId = livroId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getLivroId() {
        return livroId;
    }

    public void setLivroId(Integer livroId) {
        this.livroId = livroId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivroSelecionadoPK that = (LivroSelecionadoPK) o;
        return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(livroId, that.livroId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, livroId);
    }
}

