package com.adria.esseeujali.exception;

public class livroNaoEncontradoException extends RuntimeException{
    public livroNaoEncontradoException()
    {
        super("Livro não encontrado!");
    }
}
