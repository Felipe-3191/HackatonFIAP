package com.fiap.Hackaton.infraestructure.predio.controller;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.infraestructure.predio.dto.PredioAtualizarRequestData;
import com.fiap.Hackaton.infraestructure.predio.dto.PredioPublicData;
import com.fiap.Hackaton.infraestructure.predio.dto.PredioPublicResponseAddData;
import com.fiap.Hackaton.usecase.predio.AtualizarPredioUseCase;
import com.fiap.Hackaton.usecase.predio.dto.IPredioUpdateData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Predio", description = "Predio API")
@Controller
public class AtualizarPredioController {

    private final AtualizarPredioUseCase atualizarPredioUseCase;

    public AtualizarPredioController(AtualizarPredioUseCase atualizarPredioUseCase) {
        this.atualizarPredioUseCase = atualizarPredioUseCase;
    }

    @PutMapping("/predio/{id}")
    @Operation(summary = "Atualizar Predio")
    public ResponseEntity<PredioPublicResponseAddData> atualizarPredio (@PathVariable Long id, @RequestBody PredioAtualizarRequestData dados){
        Predio predio = this.atualizarPredioUseCase.executar(id, dados);
        return ResponseEntity.ok(new PredioPublicResponseAddData(predio));
    }
}
