package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.usecase.cliente.DeletarClienteUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cliente", description = "Cliente API")
@RestController
public class DeletarClienteController {

    private final DeletarClienteUseCase deletarClienteUseCase;

    public DeletarClienteController(DeletarClienteUseCase deletarClienteUseCase) {
        this.deletarClienteUseCase = deletarClienteUseCase;
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        deletarClienteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
