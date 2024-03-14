package com.fiap.Hackaton.usecase.servico;

import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.hotel.servico.gateway.ServicoGateway;
import com.fiap.Hackaton.infraestructure.hotel.servico.dto.ServicoRequestData;

public class AtualizarServicoUseCase {

    private final ServicoGateway servicoGateway;

    public AtualizarServicoUseCase(ServicoGateway servicoGateway) {
        this.servicoGateway = servicoGateway;
    }

    public Servico execute(Long id, ServicoRequestData dados) {

        Servico servico = this.servicoGateway.buscarPorId(id).orElseThrow();

        Servico servicoAtualizado = this.atualizarServico(servico, dados);

        return this.servicoGateway.atualizar(servicoAtualizado);
    }


    private Servico atualizarServico(Servico servico, ServicoRequestData dados) {
        servico.setNome(dados.nome());
        servico.setValor(dados.valor());
        return servico;
    }
}