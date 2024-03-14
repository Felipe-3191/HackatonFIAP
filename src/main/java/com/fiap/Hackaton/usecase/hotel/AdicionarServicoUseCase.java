package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.usecase.servico.BuscarServicoUseCase;
import com.fiap.Hackaton.usecase.servico.CriarServicoUseCase;

public class AdicionarServicoUseCase {

    private final HotelGateway hotelGateway;
    private final BuscarServicoUseCase buscarServicoUseCase;

    public AdicionarServicoUseCase(HotelGateway hotelGateway, BuscarServicoUseCase buscarServicoUseCase) {
        this.hotelGateway = hotelGateway;
        this.buscarServicoUseCase = buscarServicoUseCase;
    }

    public Hotel executar (Long hotelId, Long servicoId) {
        Hotel hotel = hotelGateway.buscarPorId(hotelId).orElseThrow();
        Servico servico = buscarServicoUseCase.execute(servicoId);

        hotel.addServico(servico);

        return hotelGateway.adicionarServico(hotel);


    }
}
