package com.adria.esseeujali.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;


@Entity
public class LivroSelecionadoParaLeitura {

    @EmbeddedId
    public LivroSelecionadoPK livroSelecionadoPk ;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LivroSelecionadoParaLeitura() {
        this.livroSelecionadoPk = new LivroSelecionadoPK();
    }

    public LivroSelecionadoParaLeitura(LivroSelecionadoPK livroSelecionadoPk) {
        this.livroSelecionadoPk = livroSelecionadoPk;
        this.lido = false;
        this.pontuacao = 0;
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

    public Boolean jaLido(){
        return this.lido;
    }
}
