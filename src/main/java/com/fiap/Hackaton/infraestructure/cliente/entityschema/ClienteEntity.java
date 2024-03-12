package com.fiap.Hackaton.infraestructure.cliente.entityschema;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class ClienteEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paisOrigem;
    private String cpf;
    private String passaporte;
    private String nome;
    private LocalDate dataNascimento;
    private String enderecoPaisOrigem;
    private String telefone;
    private String email;

    public ClienteEntity(){}


    public ClienteEntity(Cliente cliente){

        this.paisOrigem = cliente.getPaisOrigem();
        this.cpf = cliente.getCpf();
        this.passaporte = cliente.getPassaporte();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.enderecoPaisOrigem = cliente.getEnderecoPaisOrigem();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
    }

    public Cliente toCliente() {
        Cliente cliente = new Cliente(
                this.getPaisOrigem(), this.getCpf(),this.getPassaporte(),
                this.getNome(), this.getDataNascimento(),this.getEnderecoPaisOrigem(),this.getTelefone(),this.getEmail()
        );

        return cliente;
    }
    public ClienteEntity(Long id, String paisOrigem, String cpf, String passaporte, String nome, LocalDate dataNascimento,
                         String enderecoPaisOrigem, String telefone, String email) {
        this.id = id;
        this.paisOrigem = paisOrigem;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecoPaisOrigem = enderecoPaisOrigem;
        this.telefone = telefone;
        this.email = email;
    }







    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEnderecoPaisOrigem() {
        return enderecoPaisOrigem;
    }

    public void setEnderecoPaisOrigem(String enderecoPaisOrigem) {
        this.enderecoPaisOrigem = enderecoPaisOrigem;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
