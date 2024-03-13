package com.fiap.Hackaton.infraestructure.config.exception;

import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import com.fiap.Hackaton.infraestructure.cliente.gateway.ClienteDatabaseGateway;
import com.fiap.Hackaton.infraestructure.cliente.repository.ClienteRepository;
import com.fiap.Hackaton.usecase.cliente.*;
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
    public BuscarClientePorNomeUseCase buscarClientePorNomeUseCase(ClienteRepository repository){
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new BuscarClientePorNomeUseCase(clienteGateway);
    }

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(ClienteRepository repository){
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new BuscarClienteUseCase(clienteGateway);
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
}
