package dev.vitaep.hotelariaSystem.repository;

import dev.vitaep.hotelariaSystem.entity.Guest;
import dev.vitaep.hotelariaSystem.entity.specialClasses.Cpf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {

Optional<Guest> findByCpfOrEmail(Cpf cpf, String email);

}
