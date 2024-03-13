package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.usecase.cliente.AtualizarClienteUseCase;
import com.fiap.Hackaton.usecase.cliente.dto.IClienteRequestData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cliente", description = "Cliente API")
@RestController
public class AtualizarClienteController {
    private final AtualizarClienteUseCase atualizarClienteUseCase;

    public AtualizarClienteController(AtualizarClienteUseCase atualizarClienteUseCase) {
        this.atualizarClienteUseCase = atualizarClienteUseCase;
    }

    @PutMapping("/clientes/{id}")
    @Operation(summary = "Atualizar Cliente")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody IClienteRequestData dados) {
        Cliente cliente = atualizarClienteUseCase.execute(id, dados);
        return ResponseEntity.ok(cliente);
    }
}
