package com.fiap.Hackaton.domain.cliente.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    public void testCliente() {

        Long id = 1L;
        String paisOrigem = "Brasil";
        String cpf = "12345678901";
        String passaporte = "AB123456";
        String nome = "João Silva";
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        String enderecoPaisOrigem = "Rua A, 123";
        String telefone = "11987654321";
        String email = "joao.silva@example.com";


        Cliente cliente = new Cliente(id, paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);


        assertEquals(id, cliente.getId());
        assertEquals(paisOrigem, cliente.getPaisOrigem());
        assertEquals(cpf, cliente.getCpf());
        assertEquals(passaporte, cliente.getPassaporte());
        assertEquals(nome, cliente.getNome());
        assertEquals(dataNascimento, cliente.getDataNascimento());
        assertEquals(enderecoPaisOrigem, cliente.getEnderecoPaisOrigem());
        assertEquals(telefone, cliente.getTelefone());
        assertEquals(email, cliente.getEmail());
    }
}
