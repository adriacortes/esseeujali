package com.adria.esseeujali.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException() {
        super("Usuário não encontrado!");
    }
}
