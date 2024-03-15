package com.fiap.Hackaton.infraestructure.reserva.controller;

import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.infraestructure.reserva.dto.ReservaPublicData;
import com.fiap.Hackaton.usecase.reserva.BuscarReservaPorIdUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Reserva", description = "Gestão de Reservas API")
@RestController
public class BuscarReservaPorIdController {

    private final BuscarReservaPorIdUseCase buscarReservaPorIdUseCase;

    public BuscarReservaPorIdController(BuscarReservaPorIdUseCase buscarReservaPorIdUseCase) {
        this.buscarReservaPorIdUseCase = buscarReservaPorIdUseCase;
    }

    @GetMapping("/reservas/{id}")
    @Operation(summary = "Buscar reserva por id")
    public ResponseEntity<ReservaPublicData> buscarReservaPorId(@PathVariable Long id) {
        Reserva reserva = buscarReservaPorIdUseCase.executar(id);
        return ResponseEntity.ok(new ReservaPublicData(reserva));
    }
}
