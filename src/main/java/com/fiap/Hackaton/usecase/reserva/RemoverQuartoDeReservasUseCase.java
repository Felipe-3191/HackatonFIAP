package com.fiap.Hackaton.usecase.reserva;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.domain.reserva.gateway.ReservaGateway;
import com.fiap.Hackaton.infraestructure.quarto.entitySchema.QuartoEntity;

public class RemoverQuartoDeReservasUseCase {

    private final ReservaGateway reservaGateway;

    public RemoverQuartoDeReservasUseCase(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    public void executar(Quarto quarto) {
        this.reservaGateway.removerQuartoDeReservas(new QuartoEntity(quarto));
    }
}
