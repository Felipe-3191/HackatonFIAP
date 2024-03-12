package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;

public class BuscarClienteUseCase {

    private final ClienteGateway clienteGateway;

    public BuscarClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente execute(Long id) {
        return this.clienteGateway.buscarPorId(id).orElseThrow();
    }


}
