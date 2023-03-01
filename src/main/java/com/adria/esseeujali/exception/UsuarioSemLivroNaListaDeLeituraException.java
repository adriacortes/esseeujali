package com.adria.esseeujali.exception;

public class UsuarioSemLivroNaListaDeLeituraException extends RuntimeException{

    public UsuarioSemLivroNaListaDeLeituraException()
    {
        super("Livro não consta na Lista de Leitura do Usuario!");
    }
}
