package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import com.fiap.Hackaton.domain.reserva.gateway.ReservaGateway;

public class DeletarClienteUseCase {

    private final ClienteGateway clienteGateway;

    private final ReservaGateway reservaGateway;
    public DeletarClienteUseCase(ClienteGateway clienteGateway, ReservaGateway reservaGateway) {
        this.clienteGateway = clienteGateway;
        this.reservaGateway = reservaGateway;
    }

    public void execute(Long id) {
        Cliente cliente = this.clienteGateway.buscarPorId(id).orElseThrow();
        this.reservaGateway.removerClienteDeReserva(cliente);
        this.clienteGateway.deletar(cliente);
    }


}
