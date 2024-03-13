package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;

public class BuscarClientePorNomeUseCase {

    private final ClienteGateway clienteGateway;

    public BuscarClientePorNomeUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente execute(String cpf) {
        return this.clienteGateway.buscarPorNome(cpf).orElseThrow();
    }
}
