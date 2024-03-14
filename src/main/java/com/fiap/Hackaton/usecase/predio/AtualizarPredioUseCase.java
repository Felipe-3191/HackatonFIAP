package com.fiap.Hackaton.usecase.predio;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;
import com.fiap.Hackaton.usecase.predio.dto.IPredioUpdateData;

import java.util.Optional;

public class AtualizarPredioUseCase {
    private final PredioGateway predioGateway;

    public AtualizarPredioUseCase(PredioGateway predioGateway) {
        this.predioGateway = predioGateway;
    }


    public Predio executar (Long id, IPredioUpdateData dados) {

        Predio predio = this.predioGateway.buscarPorId(id).orElseThrow();
        predio.setNome(dados.nome());

        return this.predioGateway.atualizar(predio);

    }
}
