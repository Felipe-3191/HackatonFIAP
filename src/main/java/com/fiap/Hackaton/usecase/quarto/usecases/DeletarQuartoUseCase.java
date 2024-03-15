package com.fiap.Hackaton.usecase.quarto.usecases;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.Hackaton.usecase.reserva.RemoverQuartoDeReservasUseCase;

public class DeletarQuartoUseCase {

    private final QuartoGateway quartoGateway;

    private final RemoverQuartoDeReservasUseCase removerQuartoDeReservasUseCase;

    public DeletarQuartoUseCase(QuartoGateway quartoGateway, RemoverQuartoDeReservasUseCase removerQuartoDeReservasUseCase) {
        this.quartoGateway = quartoGateway;
        this.removerQuartoDeReservasUseCase = removerQuartoDeReservasUseCase;
    }

    public void executar(Long id) {
        Quarto quarto = this.quartoGateway.buscarPorId(id).orElseThrow();
        removerQuartoDeReservasUseCase.executar(quarto);
        this.quartoGateway.deletar(quarto);
    }
}
