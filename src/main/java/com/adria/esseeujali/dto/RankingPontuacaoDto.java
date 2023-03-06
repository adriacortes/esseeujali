package com.adria.esseeujali.dto;

import java.util.Objects;

public class RankingPontuacaoDto {

    Integer id_usuario;
    String nome;
    Integer pontosLeitura;

    public RankingPontuacaoDto() {
    }

    public RankingPontuacaoDto(Integer id_usuario, String nome, Integer pontosLeitura) {
        this.id_usuario = id_usuario;
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

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankingPontuacaoDto that = (RankingPontuacaoDto) o;
        return Objects.equals(id_usuario, that.id_usuario) && Objects.equals(nome, that.nome) && Objects.equals(pontosLeitura, that.pontosLeitura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_usuario, nome, pontosLeitura);
    }
}
