package com.fiap.Hackaton.infraestructure.quarto.controller;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.infraestructure.quarto.dto.QuartoPublicData;
import com.fiap.Hackaton.infraestructure.quarto.dto.QuartoSearchResponseData;
import com.fiap.Hackaton.usecase.quarto.usecases.BuscarQuartoPorQuantidadeDeHospedesUseCase;
import com.fiap.Hackaton.usecase.quarto.usecases.BuscarTodosQuartosUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Quarto", description = "Gestão de Quarto API")
@RestController
public class BuscarTodosQuartosController {

    private final BuscarTodosQuartosUseCase buscarTodosQuartosUseCase;

    public BuscarTodosQuartosController(BuscarTodosQuartosUseCase buscarTodosQuartosUseCase) {
        this.buscarTodosQuartosUseCase = buscarTodosQuartosUseCase;
    }

    @GetMapping("/quartos")
    @Operation(summary = "Buscar todos quartos")
    public ResponseEntity<List<QuartoSearchResponseData>> buscarQuartos() {
        List<Quarto> quartos = buscarTodosQuartosUseCase.execute();
        List<QuartoSearchResponseData> quartosPublicData = quartos.stream()
                .map(quarto -> new QuartoSearchResponseData(quarto))
                .collect(Collectors.toList());
        return ResponseEntity.ok(quartosPublicData);
    }
}
