package com.fiap.Hackaton.usecase.cliente.dto;

import java.time.LocalDate;

public interface IClientePublicData {

    Long id();

    String paisOrigem();

    String cpf();

    String passaporte();

    String nome();

    LocalDate dataNascimento();

    String enderecoPaisOrigem();

    String telefone();

    String email();

}
