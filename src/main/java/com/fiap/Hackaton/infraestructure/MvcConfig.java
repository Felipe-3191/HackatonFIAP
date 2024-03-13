package com.fiap.Hackaton.infraestructure;

import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.domain.hotel.servico.gateway.ServicoGateway;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;
import com.fiap.Hackaton.infraestructure.cliente.gateway.ClienteDatabaseGateway;
import com.fiap.Hackaton.infraestructure.cliente.repository.ClienteRepository;
import com.fiap.Hackaton.infraestructure.hotel.gateway.HotelDatabaseGateway;
import com.fiap.Hackaton.infraestructure.hotel.repository.HotelRepository;
import com.fiap.Hackaton.infraestructure.hotel.servico.gateway.ServicoDatabaseGateway;
import com.fiap.Hackaton.infraestructure.hotel.servico.repository.ServicoRepository;
import com.fiap.Hackaton.infraestructure.predio.gateway.PredioDatabaseGateway;
import com.fiap.Hackaton.infraestructure.predio.repository.PredioRepository;
import com.fiap.Hackaton.usecase.cliente.*;
import com.fiap.Hackaton.usecase.hotel.*;
import com.fiap.Hackaton.usecase.servico.*;
import com.fiap.Hackaton.usecase.predio.CriarPredioUseCase;
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
    public AtualizarServicoUseCase atualizarServicoUseCase (ServicoRepository repository) {
        ServicoGateway servicoGateway = new ServicoDatabaseGateway(repository);
        return new AtualizarServicoUseCase(servicoGateway);
    }

    @Bean
    public BuscarServicoUseCase buscarServicoUseCase (ServicoRepository repository) {
        ServicoGateway servicoGateway = new ServicoDatabaseGateway(repository);
        return new BuscarServicoUseCase(servicoGateway);
    }
    @Bean
    public BuscarTodosServicosUseCase buscarTodosServicosUseCase (ServicoRepository repository) {
        ServicoGateway servicoGateway = new ServicoDatabaseGateway(repository);
        return new BuscarTodosServicosUseCase(servicoGateway);
    }
    @Bean
    public CriarServicoUseCase criarServicoUseCase (ServicoRepository repository) {
        ServicoGateway servicoGateway = new ServicoDatabaseGateway(repository);
        return new CriarServicoUseCase(servicoGateway);
    }
    @Bean
    public DeletarServicoUseCase deletarServicoUseCase (ServicoRepository repository) {
        ServicoGateway servicoGateway = new ServicoDatabaseGateway(repository);
        return new DeletarServicoUseCase(servicoGateway);
    }
    @Bean
    public AdicionarPredioUseCase adicionarPredioUseCase (HotelRepository repository, CriarPredioUseCase criarPredioUseCase) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);

        return new AdicionarPredioUseCase(hotelGateway, criarPredioUseCase);
    }


    @Bean
    public CriarPredioUseCase criarPredioUseCase (PredioRepository repository) {
        PredioGateway predioGateway = new PredioDatabaseGateway(repository);
        return new CriarPredioUseCase(predioGateway);
    }
}
