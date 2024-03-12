package com.fiap.Hackaton.infraestructure.cliente.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvioEmailGateway {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String smtpAuth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String startTls;
    public void enviarEmail(String email, String mensagem) {
        System.out.println("Enviando email para " + email + " com a mensagem: " + mensagem);
    }

}
