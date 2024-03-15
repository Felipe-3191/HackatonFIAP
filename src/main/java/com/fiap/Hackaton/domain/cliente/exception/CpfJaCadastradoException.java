package com.fiap.Hackaton.domain.cliente.exception;

public class CpfJaCadastradoException extends RuntimeException {
    public CpfJaCadastradoException() {
        super("CPF encontrado na base de dados. Informe um CPF diferente para seguir.");
    }
}
