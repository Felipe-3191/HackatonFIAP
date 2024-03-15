package com.fiap.Hackaton.infraestructure.predio.controller;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.infraestructure.predio.dto.PredioPublicData;
import com.fiap.Hackaton.infraestructure.predio.dto.PredioPublicMinimalData;
import com.fiap.Hackaton.usecase.predio.BuscarPredioUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Predio", description = "Predio API")
@Controller
public class BuscarPredioController {

    private final BuscarPredioUseCase buscarPredioUseCase;

    public BuscarPredioController(BuscarPredioUseCase buscarPredioUseCase) {
        this.buscarPredioUseCase = buscarPredioUseCase;
    }

    @GetMapping("/predio/{id}")
    @Operation(summary = "Buscar Predio por Id")
    public ResponseEntity<PredioPublicMinimalData> buscarPredio(@PathVariable(name = "id") Long predioId) {
        Predio predio = this.buscarPredioUseCase.executar(predioId);
        return ResponseEntity.ok(new PredioPublicMinimalData(predio));
    }
}
