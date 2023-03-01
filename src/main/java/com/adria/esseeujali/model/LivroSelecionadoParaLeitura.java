package com.adria.esseeujali.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;


@Entity
public class LivroSelecionadoParaLeitura {

    @EmbeddedId
    public LivroSelecionadoPK livroSelecionadoPk;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @MapsId("livroId")
    @JoinColumn(name = "livro_id")
    private Livro livro;


    Boolean lido;

    Integer pontuacao;


    public LivroSelecionadoParaLeitura() {
    }

    public LivroSelecionadoParaLeitura(LivroSelecionadoPK livroSelecionadoPK, Boolean lido) {
        this.livroSelecionadoPk = livroSelecionadoPK;
        this.lido = lido;
    }

    public LivroSelecionadoPK getLivroSelecionadoPk() {
        return livroSelecionadoPk;
    }

    public void setLivroSelecionadoPk(LivroSelecionadoPK livroSelecionadoPk) {
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
