package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.infraestructure.cliente.dto.ClientePublicData;
import com.fiap.Hackaton.usecase.cliente.BuscarTodosClientesUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Cliente", description = "Cliente API")
@RestController
public class BuscarTodosClientesController {

    public BuscarTodosClientesUseCase buscarTodosClientesUseCase;

    public BuscarTodosClientesController(BuscarTodosClientesUseCase buscarTodosClientesUseCase){
        this.buscarTodosClientesUseCase = buscarTodosClientesUseCase;
    }

    @GetMapping("/clientes")
    @Operation(summary = "Buscar todos os clientes")
    public ResponseEntity<List<ClientePublicData>> buscarTodos() {
        List<Cliente> clientes = buscarTodosClientesUseCase.execute();
        List<ClientePublicData> clientesPublicData = clientes.stream()
                .map(cliente -> new ClientePublicData(cliente))
                .collect(Collectors.toList());
        return ResponseEntity.ok(clientesPublicData);
    }
}
