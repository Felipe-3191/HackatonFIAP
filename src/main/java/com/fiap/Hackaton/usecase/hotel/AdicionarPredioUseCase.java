package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.usecase.predio.CriarPredioUseCase;
import com.fiap.Hackaton.usecase.predio.dto.IPredioRequestData;

public class AdicionarPredioUseCase {

    private final HotelGateway hotelGateway;
    private final CriarPredioUseCase criarPredioUseCase;
    public AdicionarPredioUseCase(HotelGateway hotelGateway, CriarPredioUseCase criarPredioUseCase) {
        this.hotelGateway = hotelGateway;
        this.criarPredioUseCase = criarPredioUseCase;
    }

    public Hotel executar(Long hotelId, IPredioRequestData dados) {
        Hotel hotel = hotelGateway.buscarPorId(hotelId).orElseThrow();

        Predio predio = new Predio(
                dados.nome(),
                hotel,
                dados.quartos()

        );

        Predio predioSalvo = this.criarPredioUseCase.executar(predio);
        hotel.addPredio(predioSalvo);

        return this.hotelGateway.adicionarPredio(hotel);
    }

}
