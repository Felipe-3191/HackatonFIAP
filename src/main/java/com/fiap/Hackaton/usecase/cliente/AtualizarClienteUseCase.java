package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.exception.CpfObrigatorioException;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import com.fiap.Hackaton.usecase.cliente.dto.IClienteRequestData;

import static com.fiap.Hackaton.usecase.cliente.utils.ClienteUtils.*;

public class AtualizarClienteUseCase {

    private final ClienteGateway clienteGateway;

    public AtualizarClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente execute(Long id, IClienteRequestData dados) {

        Cliente cliente = this.clienteGateway.buscarPorId(id).orElseThrow();

        if (eBrasileiro(dados.paisOrigem()) && cpfNaoInformado(dados.cpf()))
            throw new CpfObrigatorioException();

        if (!eBrasileiro(dados.paisOrigem()) && passaporteNaoInformado(dados.passaporte()))
            throw new CpfObrigatorioException();

        Cliente clienteAtualizado = this.atualizarCliente(cliente, dados);

        return this.clienteGateway.atualizar(clienteAtualizado);
    }


    private Cliente atualizarCliente(Cliente cliente, IClienteRequestData dados) {
        cliente.setCpf(dados.cpf());
        cliente.setNome(dados.nome());
        cliente.setEmail(dados.email());
        cliente.setDataNascimento(dados.dataNascimento());
        cliente.setPaisOrigem(dados.paisOrigem());
        cliente.setPassaporte(dados.passaporte());

        return cliente;
    }


}
