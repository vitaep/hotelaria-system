package dev.vitaep.hotelariaSystem.controller;

import dev.vitaep.hotelariaSystem.entity.Guest;
import dev.vitaep.hotelariaSystem.entity.dto.GuestDTO;
import dev.vitaep.hotelariaSystem.service.GuestService;
import org.hibernate.sql.model.PreparableMutationOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    // POST METHOD

    @PostMapping("/post")
    public ResponseEntity<Guest> createGuest(@Validated @RequestBody GuestDTO guestDTO){

        var guest = guestService.createGuest(guestDTO);

        return ResponseEntity.ok(guest);
    }

    // GET MAPPING

    @GetMapping("/get")
    public ResponseEntity<List<Guest>> listGuests(){

        List<Guest> guestList = guestService.listGuests();

        return ResponseEntity.ok()
                .body(guestList);

    }

    // GET BY ID

    @GetMapping("/get/{id}")
    public ResponseEntity<Guest> findGuestById(@PathVariable Long id){

       var guest = guestService.findGuestById(id);

       return ResponseEntity.ok(guest);

    }

    // UPDATE

    @PutMapping("/update/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody GuestDTO guestDTO){

        var updatedGuest = guestService.updateGuest(id, guestDTO);

        return ResponseEntity.ok(updatedGuest);

    }

    // DELETE

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGuest(@PathVariable Long id){

        guestService.deleteGuest(id);

        return ResponseEntity.ok("DELETOU COM SUCESSO PORRA");

    }

}
