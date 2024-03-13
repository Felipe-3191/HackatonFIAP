package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;

public class BuscarClientePorCpfUseCase {

    private final ClienteGateway clienteGateway;

    public BuscarClientePorCpfUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente execute(String cpf) {
        return this.clienteGateway.buscarPorCpf(cpf).orElseThrow();
    }
}
