package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import com.fiap.Hackaton.usecase.cliente.dto.IClienteRequestData;

public class CriarClienteUseCase {

    private final ClienteGateway clienteGateway;


    public CriarClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente executar (IClienteRequestData dados){
        Cliente cliente = new Cliente(
                dados.paisOrigem(), dados.cpf(), dados.passaporte(),
                dados.nome(), dados.dataNascimento(),
                dados.enderecoPaisOrigem(), dados.telefone(), dados.email());

        return this.clienteGateway.criar(cliente);

    }
}