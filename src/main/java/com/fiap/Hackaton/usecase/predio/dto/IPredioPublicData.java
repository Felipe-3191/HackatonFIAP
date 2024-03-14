package com.fiap.Hackaton.usecase.predio.dto;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;

import java.util.List;

public interface IPredioPublicData {

    Hotel hotel();
    Long id();
    String nome();
    List<Quarto> quartos();

}
