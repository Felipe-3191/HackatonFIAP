package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.infraestructure.cliente.dto.ClienteRequestData;
import com.fiap.Hackaton.usecase.cliente.AtualizarClienteUseCase;
import io.restassured.mapper.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AtualizarClienteControllerTest {

    private AtualizarClienteUseCase atualizarClienteUseCase;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        atualizarClienteUseCase = Mockito.mock(AtualizarClienteUseCase.class);
        AtualizarClienteController controller = new AtualizarClienteController(atualizarClienteUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testAtualizarClienteValidRequest() throws Exception {
        // Arrange
        Cliente cliente = new Cliente();
        when(atualizarClienteUseCase.execute(anyLong(), any(ClienteRequestData.class))).thenReturn(cliente);

        // Act & Assert
        mockMvc.perform(put("/clientes/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cpf\":\"12345678901\",\"nome\":\"Fulano\",\"dataNascimento\":\"1990-01-01\",\"paisOrigem\":\"Brasil\",\"telefone\":\"52982222222\",\"enderecoPaisOrigem\":\"Brasil\"}"))
                .andExpect(status().isOk()); // Espera-se um status 200 OK
    }

    @Test
    public void testAtualizarClienteInvalidRequest() throws Exception {
        // Act & Assert
        mockMvc.perform(put("/clientes/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cpf\":null}")) // CPF inválido
                .andExpect(status().isBadRequest()); // Espera-se um erro de Bad Request
    }
}
