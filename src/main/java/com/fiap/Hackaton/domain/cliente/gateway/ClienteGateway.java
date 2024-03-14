package com.fiap.Hackaton.domain.cliente.gateway;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteGateway {


    Cliente criar (Cliente cliente);
    Cliente atualizar (Cliente cliente);

    List<Cliente> listar();

    Optional<Cliente> buscarPorId(Long id);

    Optional<Cliente> buscarPorCpf(String cpf);
    void deletar(Cliente cliente);

}
