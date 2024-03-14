package com.fiap.Hackaton.infraestructure;

import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.domain.hotel.item.gateway.ItemGateway;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;
import com.fiap.Hackaton.infraestructure.cliente.gateway.ClienteDatabaseGateway;
import com.fiap.Hackaton.infraestructure.cliente.repository.ClienteRepository;
import com.fiap.Hackaton.infraestructure.hotel.gateway.HotelDatabaseGateway;
import com.fiap.Hackaton.infraestructure.hotel.item.gateway.ItemDatabaseGateway;
import com.fiap.Hackaton.infraestructure.hotel.item.repository.ItemRepository;
import com.fiap.Hackaton.infraestructure.hotel.repository.HotelRepository;
import com.fiap.Hackaton.infraestructure.predio.gateway.PredioDatabaseGateway;
import com.fiap.Hackaton.infraestructure.predio.repository.PredioRepository;
import com.fiap.Hackaton.usecase.cliente.*;
import com.fiap.Hackaton.usecase.hotel.*;
import com.fiap.Hackaton.usecase.item.*;
import com.fiap.Hackaton.usecase.predio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {
    @Bean
    public AtualizarClienteUseCase atualizarClienteUseCase(ClienteRepository repository){
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new AtualizarClienteUseCase(clienteGateway);
    }

    @Bean
    public BuscarClientePorCpfUseCase buscarClientePorCpfUseCase(ClienteRepository repository){
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new BuscarClientePorCpfUseCase(clienteGateway);
    }

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(ClienteRepository repository){
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new BuscarClienteUseCase(clienteGateway);
    }

    @Bean
    public BuscarTodosClientesUseCase buscarTodosClientesUseCase(ClienteRepository repository){
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new BuscarTodosClientesUseCase(clienteGateway);
    }

    @Bean
    public CriarClienteUseCase criarClienteUseCase(ClienteRepository repository){
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new CriarClienteUseCase(clienteGateway);
    }

    @Bean
    public DeletarClienteUseCase deletarClienteUseCase(ClienteRepository repository){
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new DeletarClienteUseCase(clienteGateway);
    }

    @Bean
    public CriarHotelUseCase criarHotelUseCase(HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new CriarHotelUseCase(hotelGateway);
    }

    @Bean
    public AtualizarHotelUseCase atualizarHotelUseCase(HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new AtualizarHotelUseCase(hotelGateway);
    }

    @Bean
    public BuscarTodosHoteisUseCase buscarTodosHoteisUseCase (HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new BuscarTodosHoteisUseCase(hotelGateway);
    }

    @Bean
    public BuscarHotelPorCEPUseCase buscarHotelPorCEPUseCase (HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new BuscarHotelPorCEPUseCase(hotelGateway);
    }

    @Bean
    public BuscarHotelPorLogradouroUseCase buscarHotelPorLogradouroUseCase (HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new BuscarHotelPorLogradouroUseCase(hotelGateway);
    }

    @Bean
    public BuscarHotelPorNomeUseCase buscarHotelPorNomeUseCase (HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new BuscarHotelPorNomeUseCase(hotelGateway);
    }

    @Bean
    public DeletarHotelUseCase deletarHotelUseCase (HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new DeletarHotelUseCase(hotelGateway);
    }


    @Bean
    public AdicionarPredioUseCase adicionarPredioUseCase (HotelRepository repository, CriarPredioUseCase criarPredioUseCase) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);

        return new AdicionarPredioUseCase(hotelGateway, criarPredioUseCase);
    }

    @Bean
    public RemoverPredioUseCase removerPredioUseCase (HotelRepository repository, DeletarPredioUseCase deletarPredioUseCase) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);

        return new RemoverPredioUseCase(hotelGateway, deletarPredioUseCase);
    }

    @Bean
    public BuscarTodosPrediosUseCase buscarTodosPrediosUseCase (PredioRepository repository) {
        PredioGateway predioGateway = new PredioDatabaseGateway(repository);

        return new BuscarTodosPrediosUseCase(predioGateway);
    }

    @Bean
    public BuscarPredioUseCase buscarPredioUseCase (PredioRepository repository) {
        PredioGateway predioGateway = new PredioDatabaseGateway(repository);

        return new BuscarPredioUseCase(predioGateway);
    }


    @Bean
    public BuscarPredioPorNomeUseCase buscarPredioPorNomeUseCase (PredioRepository repository) {
        PredioGateway predioGateway = new PredioDatabaseGateway(repository);

        return new BuscarPredioPorNomeUseCase(predioGateway);
    }


    @Bean
    public AtualizarPredioUseCase atualizarPredioUseCase (PredioRepository repository) {
        PredioGateway predioGateway = new PredioDatabaseGateway(repository);

        return new AtualizarPredioUseCase(predioGateway);
    }

    @Bean
    public CriarPredioUseCase criarPredioUseCase (PredioRepository repository) {
        PredioGateway predioGateway = new PredioDatabaseGateway(repository);
        return new CriarPredioUseCase(predioGateway);
    }
    
@Bean
    public DeletarPredioUseCase deletarPredioUseCase (PredioRepository repository){
        PredioGateway predioGateway = new PredioDatabaseGateway(repository);
        return new DeletarPredioUseCase(predioGateway);
    }

    @Bean
    public AtualizarItemUseCase atualizarItemUseCase (ItemRepository repository) {
        ItemGateway itemGateway = new ItemDatabaseGateway(repository);
        return new AtualizarItemUseCase(itemGateway);
    }
    @Bean
    public BuscarItemUseCase buscarItemUseCase (ItemRepository repository) {
        ItemGateway itemGateway = new ItemDatabaseGateway(repository);
        return new BuscarItemUseCase(itemGateway);
    }
    @Bean
    public BuscarTodosItensUseCase buscarTodosItensUseCase (ItemRepository repository) {
        ItemGateway itemGateway = new ItemDatabaseGateway(repository);
        return new BuscarTodosItensUseCase(itemGateway);
    }
    @Bean
    public CriarItemUseCase criarItemUseCase (ItemRepository repository) {
        ItemGateway itemGateway = new ItemDatabaseGateway(repository);
        return new CriarItemUseCase(itemGateway);
    }
    @Bean
    public DeletarItemUseCase deletarItemUseCase (ItemRepository repository) {
        ItemGateway itemGateway = new ItemDatabaseGateway(repository);
        return new DeletarItemUseCase(itemGateway);
    }
}
