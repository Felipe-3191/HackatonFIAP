package com.fiap.Hackaton.usecase.quarto.usecases;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;

public class DeletarQuartoUseCase {

    private final QuartoGateway quartoGateway;

    public DeletarQuartoUseCase(QuartoGateway quartoGateway) {
        this.quartoGateway = quartoGateway;
    }

    public void executar(Long id) {
        Quarto quarto = this.quartoGateway.buscarPorId(id).orElseThrow();
        this.quartoGateway.deletar(quarto);
    }
}
