package com.fiap.Hackaton.usecase.servico;

import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.hotel.servico.gateway.ServicoGateway;

public class BuscarServicoUseCase {

    private final ServicoGateway servicoGateway;

    public BuscarServicoUseCase(ServicoGateway servicoGateway) {
        this.servicoGateway = servicoGateway;
    }

    public Servico execute(Long id) {
        return this.servicoGateway.buscarPorId(id).orElseThrow();
    }
}