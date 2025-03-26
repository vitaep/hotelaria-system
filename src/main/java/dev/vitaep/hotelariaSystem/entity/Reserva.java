package dev.vitaep.hotelariaSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @Column(name = "check_in")
    private LocalDateTime dataCheckIn;

    @Column(name = "check_out")
    private LocalDateTime dataCheckOut;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_reserva")
    private StatusReserva statusReserva;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento")
    private FormaPagamento formaPagamento;

    public enum StatusReserva {

        CONFIRMADA,
        CANCELADA,
        CONCLUIDA,
        PRESENTE

    }

    public enum FormaPagamento {

        CARTAO_CREDITO,
        CARTAO_DEBITO,
        DINHEIRO,
        PIX,
        BOLETO

    }

    public Reserva(Long id, Room room, Guest guest, LocalDateTime dataCheckIn, LocalDateTime dataCheckOut, BigDecimal valorTotal, StatusReserva statusReserva, FormaPagamento formaPagamento) {
        this.id = id;
        this.room = room;
        this.guest = guest;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.valorTotal = valorTotal;
        this.statusReserva = statusReserva;
        this.formaPagamento = formaPagamento;
    }

    public Reserva() {
    }

}
