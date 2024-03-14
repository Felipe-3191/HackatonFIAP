package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;

import java.util.List;

public class BuscarTodosClientesUseCase {
    private final ClienteGateway clienteGateway;

    public BuscarTodosClientesUseCase(ClienteGateway clienteGateway) { this.clienteGateway = clienteGateway;}

    public List<Cliente> execute() {
        return this.clienteGateway.listar();
    }
}
