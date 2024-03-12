package com.fiap.Hackaton.infraestructure.cliente.dto;

import com.fiap.Hackaton.usecase.cliente.dto.IClienteRequestData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record ClienteRequestData(

        @NotBlank(message = "Pais de origem é obrigatório")
        String paisOrigem,
        String cpf,
        String passaporte,
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @Past(message = "Data de nascimento deve ser uma data no passado no formato dd/MM/yyyy")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,
        @NotBlank(message = "Endereço do país de origem é obrigatório")
        String enderecoPaisOrigem,
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,
        @Email(message = "Email inválido")
        String email

)  implements IClienteRequestData {
}
