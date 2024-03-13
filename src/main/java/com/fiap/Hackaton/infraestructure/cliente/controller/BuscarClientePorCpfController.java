package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.usecase.cliente.BuscarClientePorCpfUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cliente", description = "Cliente API")
@RestController
public class BuscarClientePorCpfController {
    private final BuscarClientePorCpfUseCase buscarClientePorCpfUseCase;

    public BuscarClientePorCpfController(BuscarClientePorCpfUseCase buscarClientePorCpfUseCase) {
        this.buscarClientePorCpfUseCase = buscarClientePorCpfUseCase;
    }

    @GetMapping("/clientes/cpf/{cpf}")
    public ResponseEntity<Cliente> buscarClientePorCpf(@PathVariable String cpf) {
        Cliente cliente = buscarClientePorCpfUseCase.execute(cpf);
        return ResponseEntity.ok(cliente);
    }
}
