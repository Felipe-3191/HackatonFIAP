package com.fiap.Hackaton.infraestructure.config.exception;

import com.fiap.Hackaton.infraestructure.cliente.gateway.EnvioEmailGateway;
import com.fiap.Hackaton.usecase.cliente.EnvioEmailUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailMvcConfig {


    @Autowired
    private JavaMailSender javaMailSender;

    /*@Bean
    public AtualizarClienteUseCase atualizarClienteUseCase(ClienteRepository repository){
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new AtualizarClienteUseCase(clienteGateway);
    }

    @Bean
    public BuscarClientePorCpfUseCase buscarClientePorCpfUseCase(ClienteRepository repository){
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new BuscarClientePorCpfUseCase(clienteGateway);
    }

   /* @Bean
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

*/

    @Bean
    public EnvioEmailGateway envioEmailGateway() {
        return new EnvioEmailGateway(javaMailSender);
    }

    @Bean
    public EnvioEmailUseCase envioEmailUseCase(EnvioEmailGateway envioEmailGateway) {
        return new EnvioEmailUseCase(envioEmailGateway);
    }
}
