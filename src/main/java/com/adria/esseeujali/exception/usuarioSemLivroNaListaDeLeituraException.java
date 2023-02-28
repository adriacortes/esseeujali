package com.adria.esseeujali.exception;

public class usuarioSemLivroNaListaDeLeituraException extends RuntimeException{

    public usuarioSemLivroNaListaDeLeituraException()
    {
        super("Livro não consta na Lista de Leitura do Usuario!");
    }
}
