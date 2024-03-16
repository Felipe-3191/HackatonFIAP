package com.fiap.Hackaton.usecase.quarto.usecases;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.exception.QuartoNaoEncontradoException;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;

public class BuscarQuartoPorIdUseCase {

    private final QuartoGateway quartoGateway;

    public BuscarQuartoPorIdUseCase(QuartoGateway quartoGateway) {
        this.quartoGateway = quartoGateway;
    }

    public Quarto execute(Long id) {
        Quarto quarto =  this.quartoGateway.buscarPorId(id).orElseThrow();
        if(quarto.getIdHotel() == null) {
            throw  new QuartoNaoEncontradoException();
        }
        return quarto;
    }
}
