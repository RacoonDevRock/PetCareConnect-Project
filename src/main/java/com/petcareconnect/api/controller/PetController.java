package com.petcareconnect.api.controller;

import com.petcareconnect.api.exception.NoResourceFoundException;
import com.petcareconnect.api.model.Pet;
import com.petcareconnect.api.service.IPetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pet", description = "Pet management APIs")
@RestController
@RequestMapping("/pet")
public class PetController {
    private final IPetService petService;

    @Autowired
    public PetController(IPetService petService) {
        this.petService = petService;
    }

    @PostMapping("/create/{ownerId}")
    public ResponseEntity<Pet> createPet(@PathVariable Long ownerId, @RequestBody Pet pet) {
        Pet createdPet = petService.createPet(ownerId, pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPet);
    }

    @GetMapping("/find")
    public ResponseEntity<Pet> getPetByName(@RequestParam(value = "petName") String petName) {
        Pet foundPet = petService.getPetByName(petName)
                .orElseThrow(() -> new NoResourceFoundException("Not found pet with name: " + petName));
        return ResponseEntity.ok(foundPet);
    }

    @GetMapping("/allBy")
    public ResponseEntity<List<Pet>> getAllPetsByOwner(@RequestParam(value = "username") String username) {
        List<Pet> pets = petService.getAllPetsByOwner(username);
        return ResponseEntity.ok(pets);
    }

    @PutMapping("/updatePet/{petId}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long petId, @RequestBody Pet updatedPet) {
        Pet updated = petService.updatePet(petId, updatedPet);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/deletePet/{petId}")
    public ResponseEntity<String> deletePet(@PathVariable Long petId) {
        petService.deletePet(petId);
        return ResponseEntity.ok("Pet deleted successfully");
    }
}