package dev.vitaep.hotelariaSystem.entity.dto;

import dev.vitaep.hotelariaSystem.entity.Guest;
import dev.vitaep.hotelariaSystem.entity.Reserva;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ReservaDTO(@NotNull Guest guest,
                         @NotNull LocalDateTime dataCheckIn,
                         @NotNull LocalDateTime dataCheckOut,
                         @NotNull BigDecimal valorTotal,
                         @NotNull Reserva.StatusReserva statusReserva,
                         @NotNull Reserva.FormaPagamento formaPagamento
                         ) {

    public ReservaDTO toReserva(){
        return new ReservaDTO(guest,
                dataCheckIn,
                dataCheckOut,
                valorTotal,
                statusReserva,
                formaPagamento);

    }

}
