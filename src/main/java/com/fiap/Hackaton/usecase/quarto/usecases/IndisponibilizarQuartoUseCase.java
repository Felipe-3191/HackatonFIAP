package com.fiap.Hackaton.usecase.quarto.usecases;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;

public class IndisponibilizarQuartoUseCase {

    private final QuartoGateway quartoGateway;

    public IndisponibilizarQuartoUseCase(QuartoGateway quartoGateway) {
        this.quartoGateway = quartoGateway;
    }

    public Quarto executar(Long id) {
        Quarto quarto = this.quartoGateway.buscarPorId(id).orElseThrow();
        quarto.setStatus(Status.INDISPONIVEL);
        Quarto quartoIndisponivel = quartoGateway.atualizar(quarto);
        return quartoIndisponivel;
    }
}
