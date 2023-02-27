package com.adria.esseeujali.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;


@Entity
public class LivroSelecionadoParaLeitura {

  @EmbeddedId
  public LivroSelecionado livroSelecionado;
  Boolean lido;

    public LivroSelecionadoParaLeitura() {
    }

    public LivroSelecionadoParaLeitura(LivroSelecionado livroSelecionado, Boolean lido) {
        this.livroSelecionado = livroSelecionado;
        this.lido = lido;
    }

    public LivroSelecionado getLivroSelecionado() {
        return livroSelecionado;
    }

    public void setLivroSelecionado(LivroSelecionado livroSelecionado) {
        this.livroSelecionado = livroSelecionado;
    }

    public Boolean getLido() {
        return lido;
    }

    public void setLido(Boolean lido) {
        this.lido = lido;
    }
}
