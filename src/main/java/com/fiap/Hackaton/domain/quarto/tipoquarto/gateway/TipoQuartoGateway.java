package com.fiap.Hackaton.domain.quarto.tipoquarto.gateway;

import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.util.List;

public interface TipoQuartoGateway {
    List<TipoQuarto> buscaTiposQuartoPorCapacidadeTotal(Long capacidadeTotal);
}
