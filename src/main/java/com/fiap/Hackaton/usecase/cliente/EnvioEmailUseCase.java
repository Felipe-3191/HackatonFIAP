package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.infraestructure.cliente.gateway.EnvioEmailGateway;

public class EnvioEmailUseCase {
    private final EnvioEmailGateway envioEmailGateway;

    public EnvioEmailUseCase(EnvioEmailGateway envioEmailGateway) {
        this.envioEmailGateway = envioEmailGateway;
    }

    public void envioEmail(String to, String subject, String message) {
        envioEmailGateway.sendEmail(to, subject, message);
    }
}
