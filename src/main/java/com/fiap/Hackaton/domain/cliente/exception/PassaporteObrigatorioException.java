package com.fiap.Hackaton.domain.cliente.exception;

public class PassaporteObrigatorioException extends  RuntimeException {
    public PassaporteObrigatorioException(){super("Passaporte deve ser informado para estrangeiros");}
}
