package com.fiap.Hackaton.infraestructure.cliente.dto;

import com.fiap.Hackaton.usecase.cliente.dto.IClientePublicData;

import java.time.LocalDate;

public record ClientePublicData() implements IClientePublicData {
    @Override
    public Long id() {
        return null;
    }

    @Override
    public String paisOrigem() {
        return null;
    }

    @Override
    public String cpf() {
        return null;
    }

    @Override
    public String passaporte() {
        return null;
    }

    @Override
    public String nome() {
        return null;
    }

    @Override
    public LocalDate dataNascimento() {
        return null;
    }

    @Override
    public String enderecoPaisOrigem() {
        return null;
    }

    @Override
    public String telefone() {
        return null;
    }

    @Override
    public String email() {
        return null;
    }
}
