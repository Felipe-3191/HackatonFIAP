package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.infraestructure.cliente.dto.ClientePublicData;
import com.fiap.Hackaton.usecase.cliente.BuscarClientePorNomeUseCase;
import com.fiap.Hackaton.usecase.cliente.BuscarClienteUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cliente", description = "Cliente API")
@RestController
public class BuscarClienteController {
    private final BuscarClienteUseCase buscarClienteUseCase;

    public BuscarClienteController(BuscarClienteUseCase buscarClienteUseCase) {
        this.buscarClienteUseCase = buscarClienteUseCase;
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClientePublicData> buscarCliente(@PathVariable Long id) {
        Cliente cliente = buscarClienteUseCase.execute(id);
        return ResponseEntity.ok(new ClientePublicData(cliente));
    }
}
