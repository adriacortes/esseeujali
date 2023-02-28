package com.adria.esseeujali.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;


@Entity
public class LivroSelecionadoParaLeitura {

  @EmbeddedId
  public LivroSelecionado livroSelecionadoPk;
  Boolean lido;

  Integer pontuacao;


    public LivroSelecionadoParaLeitura() {
    }

    public LivroSelecionadoParaLeitura(LivroSelecionado livroSelecionado, Boolean lido) {
        this.livroSelecionadoPk = livroSelecionado;
        this.lido = lido;
    }

    public LivroSelecionado getLivroSelecionadoPk() {
        return livroSelecionadoPk;
    }

    public void setLivroSelecionadoPk(LivroSelecionado livroSelecionadoPk) {
        this.livroSelecionadoPk = livroSelecionadoPk;
    }

    public Boolean getLido() {
        return lido;
    }

    public void setLido(Boolean lido) {
        this.lido = lido;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }
}
