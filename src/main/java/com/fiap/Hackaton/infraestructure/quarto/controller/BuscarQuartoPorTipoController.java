package com.fiap.Hackaton.infraestructure.quarto.controller;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.Hackaton.infraestructure.quarto.dto.QuartoPublicData;
import com.fiap.Hackaton.infraestructure.quarto.dto.QuartoSearchResponseData;
import com.fiap.Hackaton.usecase.quarto.usecases.BuscarQuartoPorIdUseCase;
import com.fiap.Hackaton.usecase.quarto.usecases.BuscarQuartoPorTipoUseCase;
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
public class BuscarQuartoPorTipoController {

    private final BuscarQuartoPorTipoUseCase buscarQuartoPorTipoUseCase;

    public BuscarQuartoPorTipoController(BuscarQuartoPorTipoUseCase buscarQuartoPorTipoUseCase) {
        this.buscarQuartoPorTipoUseCase = buscarQuartoPorTipoUseCase;
    }

    @GetMapping("/quartos/tipo/{tipo}")
    @Operation(summary = "Buscar quarto por tipo de quarto")
    public ResponseEntity<List<QuartoSearchResponseData>> buscarQuarto(@PathVariable TipoQuarto tipoQuarto) {
        List<Quarto> quartos = buscarQuartoPorTipoUseCase.execute(tipoQuarto);
        List<QuartoSearchResponseData> quartosPublicData = quartos.stream()
                .map(quarto -> new QuartoSearchResponseData(quarto))
                .collect(Collectors.toList());
        return ResponseEntity.ok(quartosPublicData);
    }
}
