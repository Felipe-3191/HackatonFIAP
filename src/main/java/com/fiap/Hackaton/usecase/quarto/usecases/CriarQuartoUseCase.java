package com.fiap.Hackaton.usecase.quarto.usecases;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.Hackaton.usecase.quarto.dto.IQuartoRequestData;

public class CriarQuartoUseCase {

    private QuartoGateway quartoGateway;

    public CriarQuartoUseCase(QuartoGateway quartoGateway) {
        this.quartoGateway = quartoGateway;
    }

    public Quarto executar(IQuartoRequestData dados) {
        Quarto quarto = new Quarto(
                dados.predio(),
                dados.tipoQuarto(),
                dados.status(),
                dados.valorDiaria()
        );
        return this.quartoGateway.criar(quarto);
    }
}
