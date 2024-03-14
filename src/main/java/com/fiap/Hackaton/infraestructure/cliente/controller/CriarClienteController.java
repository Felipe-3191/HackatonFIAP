package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.infraestructure.cliente.dto.ClientePublicData;
import com.fiap.Hackaton.infraestructure.cliente.dto.ClienteRequestData;
import com.fiap.Hackaton.usecase.cliente.CriarClienteUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cliente", description = "Gestão de Cliente API")
@RestController
public class CriarClienteController {

    private final CriarClienteUseCase criarClienteUseCase;

    public CriarClienteController(CriarClienteUseCase criarClienteUseCase) {
        this.criarClienteUseCase = criarClienteUseCase;
    }

    @PostMapping("/clientes")
    @Operation(summary = "Criar cliente")
    public ResponseEntity<ClientePublicData> criarCliente(@Valid @RequestBody ClienteRequestData dados) {
        Cliente cliente = criarClienteUseCase.executar(dados);
        return ResponseEntity.ok(new ClientePublicData(cliente));
    }
}
