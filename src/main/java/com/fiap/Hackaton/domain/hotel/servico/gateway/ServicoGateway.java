package com.fiap.Hackaton.domain.hotel.servico.gateway;

import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;

import java.util.List;
import java.util.Optional;

public interface ServicoGateway {

    Servico criar (Servico servico);
    Servico atualizar (Servico servico);

    List<Servico> listar();

    Optional<Servico> buscarPorId(Long id);
    void deletar(Servico servico);
}
