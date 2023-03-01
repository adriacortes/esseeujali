package com.adria.esseeujali.model;

import com.adria.esseeujali.tipoenum.GeneroEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String autor;
    private Integer paginas;
    private String titulo;
    private String resumo;
    private String conteudo;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

//    @ManyToMany
//    @JoinTable(name = "livro_selecionado_para_leitura",
//            joinColumns = {@JoinColumn(name = "livro_id")},
//            inverseJoinColumns = {@JoinColumn(name = "usuario_id")})
//    private Set<Usuario> usuarios = new HashSet<>();

    public Livro() {
      
    }

    public Livro(Integer id, String autor, Integer paginas, String titulo, String resumo, String conteudo, GeneroEnum genero) {
        Id = id;
        this.autor = autor;
        this.paginas = paginas;
        this.titulo = titulo;
        this.resumo = resumo;
        this.conteudo = conteudo;
        this.genero = genero;

    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }


}
