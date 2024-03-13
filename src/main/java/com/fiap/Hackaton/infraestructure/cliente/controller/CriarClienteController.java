package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.usecase.cliente.CriarClienteUseCase;
import com.fiap.Hackaton.usecase.cliente.dto.IClienteRequestData;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cliente", description = "Cliente API")
@RestController
public class CriarClienteController {

    private final CriarClienteUseCase criarClienteUseCase;

    public CriarClienteController(CriarClienteUseCase criarClienteUseCase) {
        this.criarClienteUseCase = criarClienteUseCase;
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> criarCliente(@RequestBody IClienteRequestData dados) {
        Cliente cliente = criarClienteUseCase.executar(dados);
        return ResponseEntity.ok(cliente);
    }
}
