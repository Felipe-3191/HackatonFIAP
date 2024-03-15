package com.fiap.Hackaton.infraestructure.quarto.dto;

import java.util.List;

public record QuartoRecomendacaoPublicData(
        List<List<QuartoHotelPublicData>> quartosCombinacoes
) {


}
