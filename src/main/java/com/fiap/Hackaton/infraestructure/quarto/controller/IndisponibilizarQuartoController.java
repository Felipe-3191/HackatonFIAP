package com.fiap.Hackaton.infraestructure.quarto.controller;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.infraestructure.quarto.dto.QuartoPublicData;
import com.fiap.Hackaton.infraestructure.quarto.dto.QuartoRequestData;
import com.fiap.Hackaton.usecase.quarto.usecases.IndisponibilizarQuartoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Quarto", description = "Gestão de Quarto API")
@RestController
public class IndisponibilizarQuartoController {

    private final IndisponibilizarQuartoUseCase indisponibilizarQuartoUseCase;

    public IndisponibilizarQuartoController(IndisponibilizarQuartoUseCase indisponibilizarQuartoUseCase) {
        this.indisponibilizarQuartoUseCase = indisponibilizarQuartoUseCase;
    }

    @PutMapping("/quartos/indisponibilizar/{id}")
    @Operation(summary = "Indisponibilizar Quarto")
    public ResponseEntity<QuartoPublicData> indisponibilizarQuarto(@PathVariable Long id) {
        Quarto quarto = indisponibilizarQuartoUseCase.executar(id);
        return ResponseEntity.ok(new QuartoPublicData(quarto));
    }
}
