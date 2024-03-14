package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.infraestructure.cliente.dto.ClienteRequestData;
import com.fiap.Hackaton.usecase.cliente.CriarClienteUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CriarClienteControllerTest {

    private CriarClienteUseCase criarClienteUseCase;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        criarClienteUseCase = Mockito.mock(CriarClienteUseCase.class);
        CriarClienteController controller = new CriarClienteController(criarClienteUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testCriarClienteValidRequest() throws Exception{

        Cliente cliente = new Cliente();
        when(criarClienteUseCase.executar(ArgumentMatchers.any(ClienteRequestData.class))).thenReturn(cliente);
        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"cpf\":\"12345678901\",\"nome\":\"Fulano\",\"dataNascimento\":\"1990-01-01\",\"paisOrigem\":\"Brasil\",\"telefone\":\"52982222222\",\"enderecoPaisOrigem\":\"Brasil\"}"))
                .andExpect(status().isOk());


    }
}
