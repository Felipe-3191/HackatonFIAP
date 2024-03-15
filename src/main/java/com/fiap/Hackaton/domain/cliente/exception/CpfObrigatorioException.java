package com.fiap.Hackaton.domain.cliente.exception;

public class CpfObrigatorioException extends RuntimeException {
    public CpfObrigatorioException() {
        super("Cpf deve ser obrigatório para brasileiros");
    }
}
