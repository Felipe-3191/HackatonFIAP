package com.fiap.Hackaton.usecase.servico;

import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.hotel.servico.exception.ServicoNaoEncontradoException;
import com.fiap.Hackaton.domain.hotel.servico.gateway.ServicoGateway;

import java.util.Optional;

public class BuscarServicoUseCase {

    private final ServicoGateway servicoGateway;

    public BuscarServicoUseCase(ServicoGateway servicoGateway) {
        this.servicoGateway = servicoGateway;
    }

    public Servico execute(Long id) {
        Optional<Servico> servico = this.servicoGateway.buscarPorId(id);
        if (servico.isEmpty()) {
            throw new ServicoNaoEncontradoException();
        }
        return servico.get();
    }
}