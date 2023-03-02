package com.adria.esseeujali.model;

import java.util.Objects;

public class RankingPontuacao {

    String nome;
    Integer pontosLeitura;

    public RankingPontuacao() {
    }

    public RankingPontuacao(String nome) {
        this.nome = nome;
    }

    public RankingPontuacao(Integer pontosLeitura) {
        this.pontosLeitura = pontosLeitura;
    }

    public RankingPontuacao(String nome, Integer pontosLeitura) {
        this.nome = nome;
        this.pontosLeitura = pontosLeitura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPontosLeitura() {
        return pontosLeitura;
    }

    public void setPontosLeitura(Integer pontosLeitura) {
        this.pontosLeitura = pontosLeitura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankingPontuacao that = (RankingPontuacao) o;
        return Objects.equals(nome, that.nome) && Objects.equals(pontosLeitura, that.pontosLeitura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, pontosLeitura);
    }
}
