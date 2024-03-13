package com.fiap.Hackaton.domain.cliente.exception;

public class ClienteNaoEncontradoException extends RuntimeException {
    public ClienteNaoEncontradoException(){super("Cliente não encontrado");}
}
