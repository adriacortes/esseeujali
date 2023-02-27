package com.adria.esseeujali.exception;

public class LivroNaoEncontradoException extends RuntimeException{

    public LivroNaoEncontradoException(){
        super("Livro não encontraado!");
    }
}
