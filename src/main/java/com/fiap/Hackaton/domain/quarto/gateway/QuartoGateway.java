package com.fiap.Hackaton.domain.quarto.gateway;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface QuartoGateway {

    Quarto criar(Quarto quarto);

    Quarto atualizar(Quarto quarto);

    List<Quarto> listar();

    List<Quarto> buscarQuartoPorTipo(TipoQuarto tipoQuarto);

    Optional<Quarto> buscarPorId(Long id);

    void deletar(Quarto quarto);

    List<Quarto> listarQuartoPorPeriodoDisponibilidade(LocalDate dataInicio, LocalDate dataFim, Status status);
}
