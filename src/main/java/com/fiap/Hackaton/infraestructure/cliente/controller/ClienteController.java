package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.usecase.cliente.AtualizarClienteUseCase;
import com.fiap.Hackaton.usecase.cliente.BuscarClienteUseCase;
import com.fiap.Hackaton.usecase.cliente.CriarClienteUseCase;
import com.fiap.Hackaton.usecase.cliente.DeletarClienteUseCase;
import com.fiap.Hackaton.usecase.cliente.dto.IClienteRequestData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final CriarClienteUseCase criarClienteUseCase;
    private final AtualizarClienteUseCase atualizarClienteUseCase;
    private final DeletarClienteUseCase deletarClienteUseCase;

    private final BuscarClienteUseCase buscarClienteUseCase;

    public ClienteController(CriarClienteUseCase criarClienteUseCase,
                             AtualizarClienteUseCase atualizarClienteUseCase,
                             DeletarClienteUseCase deletarClienteUseCase,
                             BuscarClienteUseCase buscarClienteUseCase) {
        this.criarClienteUseCase = criarClienteUseCase;
        this.atualizarClienteUseCase = atualizarClienteUseCase;
        this.deletarClienteUseCase = deletarClienteUseCase;
        this.buscarClienteUseCase = buscarClienteUseCase;
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody IClienteRequestData dados) {
        Cliente cliente = criarClienteUseCase.executar(dados);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody IClienteRequestData dados) {
        Cliente cliente = atualizarClienteUseCase.execute(id, dados);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        deletarClienteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
        Cliente cliente = buscarClienteUseCase.execute(id);
        return ResponseEntity.ok(cliente);
    }
}
