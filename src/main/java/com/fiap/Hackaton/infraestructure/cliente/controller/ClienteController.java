package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.usecase.cliente.*;
import com.fiap.Hackaton.usecase.cliente.dto.IClienteRequestData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final CriarClienteUseCase criarClienteUseCase;

    private final DeletarClienteUseCase deletarClienteUseCase;

    private final BuscarClienteUseCase buscarClienteUseCase;



    private final BuscarClientePorNomeUseCase buscarClientePorNomeUseCase;

    public ClienteController(CriarClienteUseCase criarClienteUseCase,
                             DeletarClienteUseCase deletarClienteUseCase,
                             BuscarClienteUseCase buscarClienteUseCase,
                             BuscarClientePorCpfUseCase buscarClientePorCpfUseCase,
                             BuscarClientePorNomeUseCase buscarClientePorNomeUseCase) {
        this.criarClienteUseCase = criarClienteUseCase;

        this.deletarClienteUseCase = deletarClienteUseCase;
        this.buscarClienteUseCase = buscarClienteUseCase;

        this.buscarClientePorNomeUseCase = buscarClientePorNomeUseCase;
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody IClienteRequestData dados) {
        Cliente cliente = criarClienteUseCase.executar(dados);
        return ResponseEntity.ok(cliente);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        deletarClienteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }





}
