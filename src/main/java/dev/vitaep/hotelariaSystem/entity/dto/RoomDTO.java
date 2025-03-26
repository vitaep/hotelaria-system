package dev.vitaep.hotelariaSystem.entity.dto;

import dev.vitaep.hotelariaSystem.entity.Room;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RoomDTO(@NotBlank String roomNumber,
                      @NotNull Room.RoomTypeEnum roomTypeEnum,
                      @NotNull BigDecimal precoDiaria,
                      @NotNull int capacity,
                      @NotBlank String description,
                      @NotNull Room.RoomStatusEnum roomStatus
                      ) {

    public RoomDTO toRoom(){
        return new RoomDTO(roomNumber,
                roomTypeEnum,
                precoDiaria,
                capacity,
                description,
                roomStatus);

    }

}
