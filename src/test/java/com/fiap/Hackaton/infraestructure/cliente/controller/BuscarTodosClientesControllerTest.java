package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.usecase.cliente.BuscarTodosClientesUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class BuscarTodosClientesControllerTest {

    private BuscarTodosClientesUseCase buscarTodosClientesUseCase;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        buscarTodosClientesUseCase = Mockito.mock(BuscarTodosClientesUseCase.class);
        BuscarTodosClientesController controller = new BuscarTodosClientesController(buscarTodosClientesUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testBuscarTodosClientesValidRequest() throws Exception {
        Cliente cliente = new Cliente();
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);
        when(buscarTodosClientesUseCase.execute()).thenReturn(clientes);

        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk());
    }
}
