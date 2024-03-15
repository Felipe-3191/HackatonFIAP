package com.fiap.Hackaton.usecase.predio;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.predio.exception.PredioNaoEncontradoException;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;

import java.util.Optional;

public class BuscarPredioUseCase {

    private final PredioGateway predioGateway;

    public BuscarPredioUseCase(PredioGateway predioGateway) {
        this.predioGateway = predioGateway;
    }

    public Predio executar(Long id) {
        Optional<Predio> predio = this.predioGateway.buscarPorId(id);
        if (predio.isEmpty()) {
            throw new PredioNaoEncontradoException();
        }
        return predio.get();
    }
}
