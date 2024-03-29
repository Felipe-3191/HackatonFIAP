package com.fiap.Hackaton.usecase.quarto.usecases;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.Hackaton.domain.quarto.tipoquarto.gateway.TipoQuartoGateway;
import com.fiap.Hackaton.usecase.quarto.dto.IQuartoRequestData;

public class CriarQuartoUseCase {

    private QuartoGateway quartoGateway;
    private PredioGateway predioGateway;

    private TipoQuartoGateway tipoQuartoGateway;

    public CriarQuartoUseCase(
            QuartoGateway quartoGateway,
            PredioGateway predioGateway,
            TipoQuartoGateway tipoQuartoGateway) {
        this.quartoGateway = quartoGateway;
        this.predioGateway = predioGateway;
        this.tipoQuartoGateway = tipoQuartoGateway;
    }

    public Quarto executar(IQuartoRequestData dados) {

        Predio predio = predioGateway.buscarPorId(dados.idPredio()).orElseThrow();
        TipoQuarto tipoQuarto = tipoQuartoGateway.buscarPorId(dados.idTipoQuarto());
        Status status = Status.valueOf(dados.status());

        Quarto quarto = new Quarto(
                predio,
                tipoQuarto,
                status,
                dados.valorDiaria()
        );

        quarto.setIdHotel(predio.getHotel().getId());
        return this.quartoGateway.criar(quarto);
    }
}
