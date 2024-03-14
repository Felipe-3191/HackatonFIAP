package com.fiap.Hackaton.usecase.predio;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;

import java.util.List;

public class BuscarTodosPrediosUseCase {

    private final PredioGateway predioGateway;

    public BuscarTodosPrediosUseCase(PredioGateway predioGateway) {
        this.predioGateway = predioGateway;
    }

    public List<Predio> executar() {
        return this.predioGateway.listar();
    }

}
