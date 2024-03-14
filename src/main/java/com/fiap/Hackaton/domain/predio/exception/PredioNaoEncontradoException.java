package com.fiap.Hackaton.domain.predio.exception;

public class PredioNaoEncontradoException extends RuntimeException{
    public PredioNaoEncontradoException(){
        super("Predio não encontrado");
    }
}
