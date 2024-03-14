package com.fiap.Hackaton.infraestructure.hotel.controller;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.infraestructure.hotel.dto.HotelServicosPublicData;
import com.fiap.Hackaton.usecase.hotel.RemoverServicoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class RemoverServicoController {

 private final RemoverServicoUseCase removerServicoUseCase;

    public RemoverServicoController(RemoverServicoUseCase removerServicoUseCase) {
        this.removerServicoUseCase = removerServicoUseCase;
    }

    @DeleteMapping("/hotel/{idHotel}/servico/{idServico}")
    @Operation(summary = "remove um serviço de um hotel")
    public ResponseEntity<Void> removerServicoHotel(@PathVariable Long idHotel, @PathVariable Long idServico) {
        Hotel hotel = this.removerServicoUseCase.executar(idHotel, idServico);
        return ResponseEntity.noContent().build();
    }

}
