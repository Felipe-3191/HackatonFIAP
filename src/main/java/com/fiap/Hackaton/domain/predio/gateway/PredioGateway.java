package com.fiap.Hackaton.domain.predio.gateway;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.predio.entity.Predio;

import java.util.List;
import java.util.Optional;

public interface PredioGateway {

    Predio criar(Predio predio);

    Predio atualizar(Predio predio);

    List<Predio> listar();

    Optional<Predio> buscarPorId(Long id);

    Optional<List<Predio>> buscarPorNome(String nome);

    void deletar(Predio predio);

    void removerReferenciaHotel(Hotel hotel);


    //TODO avaliar se vale a pena incluir buscarPorNomeHotel

}
