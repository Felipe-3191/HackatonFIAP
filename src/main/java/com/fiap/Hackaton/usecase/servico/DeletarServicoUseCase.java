package com.fiap.Hackaton.usecase.servico;

import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.hotel.servico.gateway.ServicoGateway;

public class DeletarServicoUseCase {

    private final ServicoGateway servicoGateway;

    public DeletarServicoUseCase(ServicoGateway servicoGateway) {
        this.servicoGateway = servicoGateway;
    }

    public void execute(Long id) {
        Servico servico = this.servicoGateway.buscarPorId(id).orElseThrow();
        this.servicoGateway.deletar(servico);
    }
}