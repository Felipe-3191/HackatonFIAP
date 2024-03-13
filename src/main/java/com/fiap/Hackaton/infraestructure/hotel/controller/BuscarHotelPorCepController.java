package com.fiap.Hackaton.infraestructure.hotel.controller;

import com.fiap.Hackaton.infraestructure.hotel.dto.HotelPublicData;
import com.fiap.Hackaton.usecase.hotel.BuscarHotelPorCEPUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class BuscarHotelPorCepController {

    private final BuscarHotelPorCEPUseCase buscarHotelPorCEPUseCase;

    public BuscarHotelPorCepController(BuscarHotelPorCEPUseCase buscarHotelPorCEPUseCase) {
        this.buscarHotelPorCEPUseCase = buscarHotelPorCEPUseCase;
    }


    @GetMapping("hotel/cep/{cep}")
    @Operation(summary = "Buscar por CEP")
    public ResponseEntity<List<HotelPublicData>> buscarHotelPorCep (@PathVariable("cep") String cep) {
        List<HotelPublicData> response = this.buscarHotelPorCEPUseCase.executar(cep).stream().map(HotelPublicData::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);

    }
}
