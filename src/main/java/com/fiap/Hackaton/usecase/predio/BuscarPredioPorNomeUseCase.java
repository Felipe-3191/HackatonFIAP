package com.fiap.Hackaton.usecase.predio;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;

import java.util.List;

public class BuscarPredioPorNomeUseCase {
    private final PredioGateway predioGateway;

    public BuscarPredioPorNomeUseCase(PredioGateway predioGateway) {
        this.predioGateway = predioGateway;
    }

    public List<Predio> execute(String nome) {
        return this.predioGateway.buscarPorNome(nome).orElseThrow();
    }


}
