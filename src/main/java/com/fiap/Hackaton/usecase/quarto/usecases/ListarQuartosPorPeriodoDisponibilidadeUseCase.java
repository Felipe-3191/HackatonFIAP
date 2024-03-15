package com.fiap.Hackaton.usecase.quarto.usecases;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.Hackaton.infraestructure.quarto.entitySchema.QuartoEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ListarQuartosPorPeriodoDisponibilidadeUseCase {

    private final QuartoGateway quartoGateway;

    public ListarQuartosPorPeriodoDisponibilidadeUseCase(QuartoGateway quartoGateway) {
        this.quartoGateway = quartoGateway;
    }

    public List<Quarto> execute (LocalDate dataInicio, LocalDate dataFim, Status status){
        List<Quarto> quartosDisponiveis = this.quartoGateway.listarQuartoPorPeriodoDisponibilidade(dataInicio, dataFim, status);
        return quartosDisponiveis;
    }

}
