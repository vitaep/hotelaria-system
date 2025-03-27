package dev.vitaep.hotelariaSystem.service;

import dev.vitaep.hotelariaSystem.entity.Guest;
import dev.vitaep.hotelariaSystem.entity.dto.GuestDTO;
import dev.vitaep.hotelariaSystem.entity.specialClasses.Cpf;
import dev.vitaep.hotelariaSystem.exceptions.CpfOrEmailAlreadyExistException;
import dev.vitaep.hotelariaSystem.exceptions.GuestNotFoundException;
import dev.vitaep.hotelariaSystem.repository.GuestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    // POST METHOD

    public Guest createGuest(GuestDTO guestDTO){

        System.out.println("Requisicao recebida: " + guestDTO);

        var guest = guestRepository.findByCpfOrEmail(new Cpf(guestDTO.cpf()), guestDTO.email());
        if(guest.isPresent()){
            throw new CpfOrEmailAlreadyExistException("Esse CPF ou Email já existe no sistema.");
        }

        return guestRepository.save(guestDTO.toGuest());

    }

    // FIND ALL GUESTS METHOD

    public List<Guest> listGuests(){
        return guestRepository.findAll();
    }

    // FIND GUESTS BY ID METHOD

    public Guest findGuestById(Long id){

        Optional<Guest> guest = guestRepository.findById(id);
        if(guest.isEmpty()){
            throw new GuestNotFoundException("O hospede com o ID: " + id + " não foi encontrado.");
        }

        return guest.orElse(null);

    }

    // UPDATE GUEST

    public Guest updateGuest(Long id, GuestDTO guestDTO){

        Guest existingGuest = guestRepository.findById(id)
                .orElseThrow(() -> new GuestNotFoundException("O hospede com o ID: " + id + " não foi encontrado."));

        if(guestDTO.nome() != null && !guestDTO.nome().isEmpty()){
            existingGuest.setNome(guestDTO.nome());
        }
        if(guestDTO.cpf() != null && !guestDTO.cpf().isEmpty()){
            existingGuest.setCpf(new Cpf(guestDTO.cpf()));
        }
        if(guestDTO.telefone() != null && !guestDTO.telefone().isEmpty()){
            existingGuest.setTelefone(guestDTO.telefone());
        }
        if(guestDTO.email() != null && !guestDTO.email().isEmpty()){
            existingGuest.setEmail(guestDTO.email());
        }
        if(guestDTO.nascimento() != null){
            existingGuest.setNascimento(guestDTO.nascimento());
        }
        if(guestDTO.endereco() != null && !guestDTO.endereco().isEmpty()){
            existingGuest.setEndereco(guestDTO.endereco());
        }

        return guestRepository.save(existingGuest);

    }

    // DELETE GUEST

    public void deleteGuest(Long id){

        Guest toDelete = guestRepository.findById(id)
                        .orElseThrow(() -> new GuestNotFoundException("O hospede com o ID: " + id + " não foi encontrado."));

        guestRepository.deleteById(id);

    }

}
