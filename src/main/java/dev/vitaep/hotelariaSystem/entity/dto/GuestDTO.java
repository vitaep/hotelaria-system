package dev.vitaep.hotelariaSystem.entity.dto;

import dev.vitaep.hotelariaSystem.entity.Guest;
import dev.vitaep.hotelariaSystem.entity.specialClasses.Cpf;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record GuestDTO(@NotBlank String nome,
                       @NotBlank String cpf,
                       @NotBlank String telefone,
                       @NotBlank String email,
                       @NotNull LocalDateTime nascimento,
                       @NotBlank String endereco
                       ) {

    public Guest toGuest(){
        return new Guest(
                nome,
                new Cpf(cpf),
                telefone,
                email,
                nascimento,
                endereco
        );
    }

}
