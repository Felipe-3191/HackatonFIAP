package com.fiap.Hackaton.usecase.predio;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;

public class BuscarPredioUseCase {

    private final PredioGateway predioGateway;

    public BuscarPredioUseCase(PredioGateway predioGateway) {
        this.predioGateway = predioGateway;
    }

    public Predio executar(Long id) {
        return this.predioGateway.buscarPorId(id).orElseThrow();
    }
}
