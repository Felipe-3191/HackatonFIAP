package com.fiap.Hackaton.usecase.quarto.usecases;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.Hackaton.domain.quarto.tipoquarto.gateway.TipoQuartoGateway;
import com.fiap.Hackaton.usecase.quarto.dto.IQuartoRequestData;

public class AtualizarQuartoUseCase {

    private  final QuartoGateway quartoGateway;

    private PredioGateway predioGateway;

    private TipoQuartoGateway tipoQuartoGateway;

    public AtualizarQuartoUseCase( QuartoGateway quartoGateway,
                                   PredioGateway predioGateway,
                                   TipoQuartoGateway tipoQuartoGateway) {
        this.quartoGateway = quartoGateway;
        this.predioGateway = predioGateway;
        this.tipoQuartoGateway = tipoQuartoGateway;
    }

    public Quarto execute(Long id, IQuartoRequestData dados) {
        Quarto quarto = quartoGateway.buscarPorId(id).orElseThrow();
       Quarto quartoAtualizado = this.atualizarQuarto(quarto, dados);
        return quartoGateway.atualizar(quartoAtualizado);
    }

    private Quarto atualizarQuarto(Quarto quarto, IQuartoRequestData dados){

        Predio predio = predioGateway.buscarPorId(dados.idPredio()).orElseThrow();
        TipoQuarto tipoQuarto = tipoQuartoGateway.buscarPorId(dados.idTipoQuarto());
        Status status = Status.valueOf(dados.status());

        quarto.setTipoQuarto(tipoQuarto);
        quarto.setPredio(predio);
        quarto.setStatus(status);
        quarto.setIdHotel(predio.getHotel().getId());
        quarto.setValorDiaria(dados.valorDiaria());
        return  quarto;
    }
}
