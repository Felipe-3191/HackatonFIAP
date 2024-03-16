package com.fiap.Hackaton.infraestructure.reserva.controller;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.infraestructure.quarto.dto.QuartoPublicData;
import com.fiap.Hackaton.infraestructure.quarto.dto.QuartoRequestData;
import com.fiap.Hackaton.infraestructure.reserva.dto.ReservaPublicData;
import com.fiap.Hackaton.infraestructure.reserva.dto.ReservaRequestData;
import com.fiap.Hackaton.infraestructure.reserva.dto.ReservaReservarData;
import com.fiap.Hackaton.infraestructure.reserva.reservaServico.dto.ReservaServicoRequestData;
import com.fiap.Hackaton.usecase.quarto.usecases.CriarQuartoUseCase;
import com.fiap.Hackaton.usecase.reserva.ReservarReservaUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Reserva", description = "Gestão de Reservas API")
@RestController
public class ReservaReservarController {

    private final ReservarReservaUseCase reservarReservaUseCase;

    public ReservaReservarController(ReservarReservaUseCase reservarReservaUseCase) {
        this.reservarReservaUseCase = reservarReservaUseCase;
    }

    @PostMapping("/reservas")
    @Operation(summary = "Reservar")
    public ResponseEntity<ReservaReservarData> reservar(@Valid @RequestBody ReservaRequestData dados) {
        Reserva reserva = reservarReservaUseCase.executar(dados);
        return ResponseEntity.ok(new ReservaReservarData(reserva));
    }
}
