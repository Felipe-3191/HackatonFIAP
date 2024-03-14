package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.infraestructure.cliente.dto.ClienteRequestData;
import com.fiap.Hackaton.usecase.cliente.CriarClienteUseCase;
import com.fiap.Hackaton.usecase.cliente.DeletarClienteUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DeletarClienteControllerTest {

    private DeletarClienteUseCase deletarClienteUseCase;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        deletarClienteUseCase = Mockito.mock(DeletarClienteUseCase.class);
        DeletarClienteController controller = new DeletarClienteController(deletarClienteUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testDeletarClienteValidRequest() throws Exception{

        doNothing().when(deletarClienteUseCase).execute(ArgumentMatchers.anyLong());

    }
}
