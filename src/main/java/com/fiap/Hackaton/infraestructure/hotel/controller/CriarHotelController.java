package com.fiap.Hackaton.infraestructure.hotel.controller;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.infraestructure.hotel.dto.HotelCadastroRequestData;
import com.fiap.Hackaton.infraestructure.hotel.dto.HotelPublicData;
import com.fiap.Hackaton.usecase.hotel.CriarHotelUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class CriarHotelController {

    private final CriarHotelUseCase criarHotelUseCase;

    public CriarHotelController(CriarHotelUseCase criarHotelUseCase) {
        this.criarHotelUseCase = criarHotelUseCase;
    }

    @PostMapping("/hotel")
    @Operation(summary = "Criar Hotel")
    public ResponseEntity<HotelPublicData> criarHotel(@Valid @RequestBody HotelCadastroRequestData dados) {
        Hotel hotel = criarHotelUseCase.executar(dados);
        return ResponseEntity.ok(new HotelPublicData(hotel));

    }

}
