package com.fiap.Hackaton.infraestructure;

import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.infraestructure.cliente.gateway.ClienteDatabaseGateway;
import com.fiap.Hackaton.infraestructure.cliente.repository.ClienteRepository;
import com.fiap.Hackaton.infraestructure.hotel.gateway.HotelDatabaseGateway;
import com.fiap.Hackaton.infraestructure.hotel.repository.HotelRepository;
import com.fiap.Hackaton.usecase.cliente.*;
import com.fiap.Hackaton.usecase.hotel.*;
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
        return new BuscarHotelPorNomeUseCase(git shotelGateway);
    }

    @Bean
    public DeletarHotelUseCase deletarHotelUseCase (HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new DeletarHotelUseCase(hotelGateway);
    }


}
