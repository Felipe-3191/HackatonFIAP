package com.fiap.Hackaton.usecase.servico.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IServicoPublicData {

     Long id();
     String nome();

     BigDecimal valor();

}
