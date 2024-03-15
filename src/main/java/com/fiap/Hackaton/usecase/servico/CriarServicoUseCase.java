package com.fiap.Hackaton.usecase.servico;

import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.hotel.servico.gateway.ServicoGateway;
import com.fiap.Hackaton.usecase.servico.dto.IServicoRequestData;

public class CriarServicoUseCase {

    private final ServicoGateway servicoGateway;

    public CriarServicoUseCase(ServicoGateway servicoGateway) {
        this.servicoGateway = servicoGateway;
    }

    public Servico executar(IServicoRequestData dados) {

        Servico servico = new Servico(
                dados.nome(), dados.valor());

        return this.servicoGateway.criar(servico);
    }
}