package dev.vitaep.hotelariaSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_quarto")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "roomNumber")
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "roomType")
    private RoomTypeEnum roomType;

    @Column(name = "precoDiaria")
    private BigDecimal precoDiaria;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "rooomStatus")
    private RoomStatusEnum roomStatus;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Reserva> reservas = new ArrayList<>();

    // ENUMS

    public enum RoomStatusEnum{

        DISPONIVEL,
        OCUPADO,
        EM_MANUTENCAO

    }

    public enum RoomTypeEnum{

        SOLTEIRO,
        DUPLO,
        SUITE,
        FAMILIAR

    }

    public Room(Long id, String roomNumber, RoomTypeEnum roomType, BigDecimal precoDiaria, int capacity, String description, RoomStatusEnum roomStatus, List<Reserva> reservas) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.precoDiaria = precoDiaria;
        this.capacity = capacity;
        this.description = description;
        this.roomStatus = roomStatus;
        this.reservas = reservas;
    }

    public Room() {
    }
}
