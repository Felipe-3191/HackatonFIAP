package com.fiap.Hackaton.infraestructure.cliente.dto;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.usecase.cliente.dto.IClientePublicData;

import java.time.LocalDate;

public record ClientePublicData(
        Long id,
        String paisOrigem,
        String cpf,
        String passaporte,
        String nome,
        LocalDate dataNascimento,
        String enderecoPaisOrigem,
        String telefone,
        String email
) implements IClientePublicData {

    public ClientePublicData(Cliente cliente) {
        this(
                cliente.getId(),
                cliente.getPaisOrigem(),
                cliente.getCpf(),
                cliente.getPassaporte(),
                cliente.getNome(),
                cliente.getDataNascimento(),
                cliente.getEnderecoPaisOrigem(),
                cliente.getTelefone(),
                cliente.getEmail()
        );
    }
}
