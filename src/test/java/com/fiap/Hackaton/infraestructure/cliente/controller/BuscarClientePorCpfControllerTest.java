package com.fiap.Hackaton.infraestructure.cliente.controller;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.usecase.cliente.BuscarClientePorCpfUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

public class BuscarClientePorCpfControllerTest {

    private BuscarClientePorCpfUseCase buscarClientePorCpfUseCase;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        buscarClientePorCpfUseCase = Mockito.mock(BuscarClientePorCpfUseCase.class);
        BuscarClientePorCpfController controller = new BuscarClientePorCpfController(buscarClientePorCpfUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testBuscarClientePorCpfValidRequest() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCpf("12345678901");

        when(buscarClientePorCpfUseCase.execute(anyString())).thenReturn(cliente);

        mockMvc.perform(get("/clientes/cpf/{cpf}", "12345678901"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cpf", is("12345678901")));
    }

}
