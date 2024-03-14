package com.fiap.Hackaton.infraestructure.quarto.controller;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.infraestructure.quarto.dto.QuartoPublicData;
import com.fiap.Hackaton.usecase.quarto.usecases.BuscarQuartoPorIdUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Quarto", description = "Gestão de Quarto API")
@RestController
public class BuscarQuartoPorIdController {

    private final BuscarQuartoPorIdUseCase buscarQuartoPorIdUseCase;

    public BuscarQuartoPorIdController(BuscarQuartoPorIdUseCase buscarQuartoPorIdUseCase) {
        this.buscarQuartoPorIdUseCase = buscarQuartoPorIdUseCase;
    }

    @GetMapping("/quartos/{id}")
    @Operation(summary = "Buscar quarto por id")
    public ResponseEntity<QuartoPublicData> buscarQuarto(@PathVariable Long id) {
        Quarto quarto = buscarQuartoPorIdUseCase.execute(id);
        return ResponseEntity.ok(new QuartoPublicData(quarto));
    }
}
