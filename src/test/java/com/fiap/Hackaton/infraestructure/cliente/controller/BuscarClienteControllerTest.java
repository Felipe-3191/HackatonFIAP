package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.usecase.cliente.BuscarClienteUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class BuscarClienteControllerTest {

    private BuscarClienteUseCase buscarClienteUseCase;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        buscarClienteUseCase = Mockito.mock(BuscarClienteUseCase.class);
        BuscarClienteController controller = new BuscarClienteController(buscarClienteUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testBuscarClienteValidRequest() throws Exception {
        Cliente cliente = new Cliente();
        when(buscarClienteUseCase.execute(anyLong())).thenReturn(cliente);

        mockMvc.perform(get("/clientes/{id}", 1L))
                .andExpect(status().isOk());

    }
}
