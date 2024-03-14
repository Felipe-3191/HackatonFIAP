package com.fiap.Hackaton.usecase.quarto.usecases;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.util.List;

public class BuscarTodosQuartosUseCase {

    private final QuartoGateway quartoGateway;

    public BuscarTodosQuartosUseCase(QuartoGateway quartoGateway) {
        this.quartoGateway = quartoGateway;
    }

    public List<Quarto> execute() {
        return this.quartoGateway.listar();
    }
}
