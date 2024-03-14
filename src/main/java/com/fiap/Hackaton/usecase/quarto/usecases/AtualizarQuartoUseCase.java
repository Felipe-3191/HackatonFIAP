package com.fiap.Hackaton.usecase.quarto.usecases;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.Hackaton.usecase.quarto.dto.IQuartoRequestData;

public class AtualizarQuartoUseCase {

    private  final QuartoGateway quartoGateway;

    public AtualizarQuartoUseCase(QuartoGateway quartoGateway) {
        this.quartoGateway = quartoGateway;
    }

    public Quarto execute(Long id, IQuartoRequestData dados) {
        Quarto quarto = quartoGateway.buscarPorId(id).orElseThrow();
       Quarto quartoAtualizado = this.atualizarQuarto(quarto, dados);
        return quartoGateway.atualizar(quartoAtualizado);
    }

    private Quarto atualizarQuarto(Quarto quarto, IQuartoRequestData dados){
        quarto.setTipoQuarto(dados.tipoQuarto());
        quarto.setPredio(dados.predio());
        quarto.setStatus(dados.status());
        quarto.setIdHotel(dados.predio().getHotel().getId());
        quarto.setValorDiaria(dados.valorDiaria());
        return  quarto;
    }
}
