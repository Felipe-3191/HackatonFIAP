package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.usecase.servico.BuscarServicoUseCase;

public class RemoverServicoUseCase {

    private final HotelGateway hotelGateway;
    private final BuscarServicoUseCase buscarServicoUseCase;

    public RemoverServicoUseCase(HotelGateway hotelGateway, BuscarServicoUseCase buscarServicoUseCase) {
        this.hotelGateway = hotelGateway;
        this.buscarServicoUseCase = buscarServicoUseCase;
    }


    public Hotel executar(Long hotelId, Long servicoId) {
        Hotel hotel = hotelGateway.buscarPorId(hotelId).orElseThrow();
        Servico servico = buscarServicoUseCase.execute(servicoId);


        hotel.removerServico(servico);

        return hotelGateway.removerServico(hotel);


    }
}
