package com.fiap.Hackaton.usecase.predio;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.predio.exception.PredioNaoEncontradoException;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.Optional;

public class BuscarTodosPrediosUseCase {

    private final PredioGateway predioGateway;

    public BuscarTodosPrediosUseCase(PredioGateway predioGateway) {
        this.predioGateway = predioGateway;
    }

    public List<Predio> executar() {
        List<Predio> predios = this.predioGateway.listar();
        if (predios.isEmpty()) {
            throw new PredioNaoEncontradoException();
        }

        return predios;
    }

}
