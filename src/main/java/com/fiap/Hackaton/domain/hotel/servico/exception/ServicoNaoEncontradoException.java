package com.fiap.Hackaton.domain.hotel.servico.exception;

public class ServicoNaoEncontradoException extends RuntimeException {
    public ServicoNaoEncontradoException(){super("Servico não encontrado");}
}
