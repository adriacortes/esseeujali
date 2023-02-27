package com.adria.esseeujali.dto;

import java.util.Objects;

public class LivroDto {
    private long Id;
    private String autor;
    private Integer paginas;
    private String titulo;
    private String resumo;
    private String conteudo;

    private String genero;


    public LivroDto() {
    }

    public LivroDto(long id, String autor, Integer paginas, String titulo) {
        Id = id;
        this.autor = autor;
        this.paginas = paginas;
        this.titulo = titulo;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivroDto livroDto = (LivroDto) o;
        return Id == livroDto.Id && Objects.equals(autor, livroDto.autor) && Objects.equals(paginas, livroDto.paginas) && Objects.equals(titulo, livroDto.titulo) && Objects.equals(resumo, livroDto.resumo) && Objects.equals(conteudo, livroDto.conteudo) && Objects.equals(genero, livroDto.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, autor, paginas, titulo, resumo, conteudo, genero);
    }
}