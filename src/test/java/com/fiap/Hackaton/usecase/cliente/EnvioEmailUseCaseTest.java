package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.infraestructure.cliente.gateway.EnvioEmailGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class EnvioEmailUseCaseTest {

    @Mock
    private EnvioEmailGateway envioEmailGateway;

    private EnvioEmailUseCase envioEmailUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        envioEmailUseCase = new EnvioEmailUseCase(envioEmailGateway);
    }

    @Test
    public void shouldSendEmailWhenParametersAreValid() {
        String to = "test@test.com";
        String subject = "Test Subject";
        String message = "Test Message";

        envioEmailUseCase.envioEmail(to, subject, message);

        verify(envioEmailGateway, times(1)).sendEmail(to, subject, message);
    }

    @Test
    public void shouldThrowExceptionWhenEmailSendingFails() {
        String to = "test@test.com";
        String subject = "Test Subject";
        String message = "Test Message";

        doThrow(RuntimeException.class).when(envioEmailGateway).sendEmail(to, subject, message);

        assertThrows(RuntimeException.class, () -> envioEmailUseCase.envioEmail(to, subject, message));
    }
}