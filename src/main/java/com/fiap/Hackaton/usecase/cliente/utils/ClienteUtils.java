package com.fiap.Hackaton.usecase.cliente.utils;

public class ClienteUtils {

    public static boolean passaporteNaoInformado(String passaporte){
        return passaporte == null || passaporte.isBlank();
    }

    public static boolean cpfNaoInformado(String cpf) {
        return cpf == null || cpf.isBlank();
    }

    public static boolean eBrasileiro(String pais){
        String paisOrigem = pais.toLowerCase();
        return (paisOrigem.startsWith("br") || paisOrigem.equalsIgnoreCase("brasil"));
    }
}
