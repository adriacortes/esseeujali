package com.adria.esseeujali.model;

import java.util.Objects;

public class Pontuacao {

    Integer pontos;

    public Pontuacao() {
    }

    public Pontuacao(Integer pontos) {
        this.pontos = pontos;
    }


    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pontuacao pontuacao = (Pontuacao) o;
        return Objects.equals(pontos, pontuacao.pontos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pontos);
    }
}
