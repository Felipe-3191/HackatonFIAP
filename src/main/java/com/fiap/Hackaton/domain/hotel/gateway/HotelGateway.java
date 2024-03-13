package com.fiap.Hackaton.domain.hotel.gateway;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelGateway {


    Hotel criar (Hotel hotel);

    Hotel atualizar (Hotel hotel);

    List<Hotel> listar ();

    Optional<Hotel> buscarPorId(Long id);

    Optional<List<Hotel>> buscarPorNome(String nome);
    Optional<List<Hotel>> buscarPorLogradouro (String endereco);

    Optional<List<Hotel>> buscarPorCep (String cep);


    void deletar(Hotel hotel);





}
