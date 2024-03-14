package com.fiap.Hackaton.usecase.servico;

import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.hotel.servico.gateway.ServicoGateway;

import java.util.List;

public class BuscarTodosServicosUseCase {
    private final ServicoGateway servicoGateway;

    public BuscarTodosServicosUseCase(ServicoGateway servicoGateway) { this.servicoGateway = servicoGateway;}

    public List<Servico> execute() {
        return this.servicoGateway.listar();
    }
}