package com.fiap.Hackaton.infraestructure.hotel.controller;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.infraestructure.hotel.dto.HotelAtualizarRequestData;
import com.fiap.Hackaton.infraestructure.hotel.dto.HotelPublicData;
import com.fiap.Hackaton.usecase.hotel.AtualizarHotelUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class AtualizarHotelController {

    private final AtualizarHotelUseCase atualizarHotelUseCase;

    public AtualizarHotelController(AtualizarHotelUseCase atualizarHotelUseCase) {
        this.atualizarHotelUseCase = atualizarHotelUseCase;
    }

    @PutMapping("/hotel/{id}")
    @Operation(summary = "Atualizar Hotel")
    public ResponseEntity<HotelPublicData> atualizarHotel(@PathParam("id") Long id, @RequestBody HotelAtualizarRequestData data) {
        Hotel hotelAtualizado = this.atualizarHotelUseCase.executar(id, data);
        return ResponseEntity.ok(new HotelPublicData(hotelAtualizado));
    }


}
