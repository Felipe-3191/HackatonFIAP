package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;

public class DeletarClienteUseCase {

    private final ClienteGateway clienteGateway;

    public DeletarClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public void execute(Long id) {
        Cliente cliente = this.clienteGateway.buscarPorId(id).orElseThrow();
        this.clienteGateway.deletar(cliente);
    }



}
