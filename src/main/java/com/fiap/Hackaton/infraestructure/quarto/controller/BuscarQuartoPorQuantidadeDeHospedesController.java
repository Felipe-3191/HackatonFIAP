package com.fiap.Hackaton.infraestructure.quarto.controller;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.infraestructure.quarto.dto.QuartoPublicData;
import com.fiap.Hackaton.usecase.quarto.usecases.BuscarQuartoPorQuantidadeDeHospedesUseCase;
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
public class BuscarQuartoPorQuantidadeDeHospedesController {
    private final BuscarQuartoPorQuantidadeDeHospedesUseCase buscarQuartoPorQuantidadeDeHospedesUseCase;

    public BuscarQuartoPorQuantidadeDeHospedesController(BuscarQuartoPorQuantidadeDeHospedesUseCase buscarQuartoPorQuantidadeDeHospedesUseCase) {
        this.buscarQuartoPorQuantidadeDeHospedesUseCase = buscarQuartoPorQuantidadeDeHospedesUseCase;
    }

    @GetMapping("/quartos/{quantidadeHospedes}")
    @Operation(summary = "Buscar quarto por quantidade de hóspedes")
    public ResponseEntity<List<QuartoPublicData>> buscarQuarto(@PathVariable Long quantidadeHospedes) {
        List<Quarto> quartos = buscarQuartoPorQuantidadeDeHospedesUseCase.execute(quantidadeHospedes);
        List<QuartoPublicData> quartosPublicData = quartos.stream()
                .map(quarto -> new QuartoPublicData(quarto))
                .collect(Collectors.toList());
        return ResponseEntity.ok(quartosPublicData);
    }
}