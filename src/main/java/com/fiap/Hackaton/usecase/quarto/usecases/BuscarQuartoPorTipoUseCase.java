package com.fiap.Hackaton.usecase.quarto.usecases;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.util.List;

public class BuscarQuartoPorTipoUseCase {
    private final QuartoGateway quartoGateway;

    public BuscarQuartoPorTipoUseCase(QuartoGateway quartoGateway) {
        this.quartoGateway = quartoGateway;
    }

    public List<Quarto> execute(TipoQuarto tipoQuarto) {
        return this.quartoGateway.buscarQuartoPorTipo(tipoQuarto);
    }
}
