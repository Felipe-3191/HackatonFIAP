package com.fiap.Hackaton.usecase.cliente.dto;

import java.time.LocalDate;

public interface IClienteRequestData {


    String paisOrigem();

    String cpf();

    String passaporte();

    String nome();

    LocalDate dataNascimento();

    String enderecoPaisOrigem();

    String telefone();

    String email();

}
