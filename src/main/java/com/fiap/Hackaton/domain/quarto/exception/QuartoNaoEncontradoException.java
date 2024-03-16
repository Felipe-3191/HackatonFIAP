package com.fiap.Hackaton.domain.quarto.exception;

public class QuartoNaoEncontradoException  extends RuntimeException {
    public QuartoNaoEncontradoException() {
        super("Quarto nao encontrado");
    }
}
