package com.fiap.Hackaton.infraestructure.endereco.dto;

public record EnderecoCadastroRequestData(
        String logradouro,
        String cep,
        String cidade,
        String estado
) {
}
