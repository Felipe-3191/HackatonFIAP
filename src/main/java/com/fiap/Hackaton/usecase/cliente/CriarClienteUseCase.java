package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.exception.CpfJaCadastradoException;
import com.fiap.Hackaton.domain.cliente.exception.CpfObrigatorioException;
import com.fiap.Hackaton.domain.cliente.exception.PassaporteObrigatorioException;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import com.fiap.Hackaton.usecase.cliente.dto.IClienteRequestData;

import static com.fiap.Hackaton.usecase.cliente.utils.ClienteUtils.*;

public class CriarClienteUseCase {

    private final ClienteGateway clienteGateway;


    public CriarClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente executar (IClienteRequestData dados) {

        if(eBrasileiro(dados.paisOrigem()) && cpfNaoInformado(dados.cpf()))
            throw new CpfObrigatorioException();

        if(!eBrasileiro(dados.paisOrigem()) && passaporteNaoInformado(dados.passaporte()))
            throw new PassaporteObrigatorioException();

        if(dados.cpf() != null && cpfCadastrado(dados.cpf())){
            throw new CpfJaCadastradoException();
        }

        Cliente cliente = new Cliente(
                dados.paisOrigem(), dados.cpf(), dados.passaporte(),
                dados.nome(), dados.dataNascimento(),
                dados.enderecoPaisOrigem(), dados.telefone(), dados.email());

        return this.clienteGateway.criar(cliente);

    }

    private boolean cpfCadastrado(String cpf){
        return this.clienteGateway.buscarPorCpf(cpf).isPresent();
    }
}
