package com.adria.esseeujali.exception;

public class PontuacaoJaGeradaParaEsteLivroException extends RuntimeException {

    public PontuacaoJaGeradaParaEsteLivroException() {
        super("Já foi gerado pontuação para leitura deste livro!");
    }
}
