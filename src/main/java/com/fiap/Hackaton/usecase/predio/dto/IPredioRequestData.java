package com.fiap.Hackaton.usecase.predio.dto;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;

import java.util.List;

public interface IPredioRequestData {

    String nome();
    List<Quarto> quartos();
}
