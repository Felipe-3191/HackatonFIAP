package com.fiap.Hackaton.infraestructure.hotel.gateway;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.infraestructure.hotel.entityschema.HotelEntity;
import com.fiap.Hackaton.infraestructure.hotel.repository.HotelRepository;
import com.fiap.Hackaton.infraestructure.hotel.servico.entityschema.ServicoEntity;
import com.fiap.Hackaton.infraestructure.predio.entityschema.PredioEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HotelDatabaseGateway implements HotelGateway {

    private final HotelRepository repository;

    public HotelDatabaseGateway(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Hotel criar(Hotel hotel) {
        HotelEntity entity = new HotelEntity(hotel);
        return this.repository.save(entity).toEntity();
    }

    @Override
    public Hotel atualizar(Hotel hotel) {
        HotelEntity entity = new HotelEntity(hotel);
        return this.repository.save(entity).toEntity();
    }

    @Override
    public Hotel adicionarPredio(Hotel hotel) {
        HotelEntity entity = new HotelEntity(hotel);
        entity.setPredios(hotel.getPredios().stream().map(PredioEntity::new).collect(Collectors.toList()));
        return this.repository.save(entity).toEntityWithPredios();
    }

    @Override
    public Hotel adicionarServico(Hotel hotel) {
        HotelEntity entity = new HotelEntity(hotel);
        entity.setServicos(hotel.getServicosDisponiveis().stream().map(ServicoEntity::new).collect(Collectors.toSet()));
        return this.repository.save(entity).toEntityWithServicos();
    }

    @Override
    public Hotel adicionarItem(Hotel hotel) {
        return null;
    }

    @Override
    public List<Hotel> listar() {
        return this.repository.findAll().stream().map(HotelEntity::toEntity).collect(Collectors.toList());
    }

    @Override
    public Optional<Hotel> buscarPorId(Long id) {
        return this.repository.findById(id).map(HotelEntity::toCompleteEntity);
    }

    @Override
    public Optional<List<Hotel>> buscarPorNome(String nome) {
        return this.repository.findByNome(nome).map(l -> l.stream().map(HotelEntity::toCompleteEntity).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<Hotel>> buscarPorLogradouro(String endereco) {

        return this.repository.findByEnderecoLogradouro(endereco).map(l -> l.stream().map(HotelEntity::toCompleteEntity).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<Hotel>> buscarPorCep(String cep) {
        return this.repository.findByEnderecoCep(cep).map(l -> l.stream().map(HotelEntity::toCompleteEntity).collect(Collectors.toList()));
    }

    @Override
    public void deletar(Hotel hotel) {
        HotelEntity entity = new HotelEntity(hotel);
        this.repository.delete(entity);
    }
}
