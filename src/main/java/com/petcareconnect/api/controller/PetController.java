package com.petcareconnect.api.controller;

import com.petcareconnect.api.model.Pet;
import com.petcareconnect.api.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    private final IPetService petService;

    @Autowired
    public PetController(IPetService petService) {
        this.petService = petService;
    }

    @PostMapping("/create")
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        return new ResponseEntity<>(petService.createPet(pet), HttpStatus.CREATED);
    }

    @GetMapping("/{petId}")
    public ResponseEntity<?> getPetById(@PathVariable Long petId) {
        return new ResponseEntity<>(petService.getPetById(petId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pet>> getAllPets() {
        return new ResponseEntity<>(petService.getAllPets(), HttpStatus.OK);
    }

    @PutMapping("/updatePet/{petId}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long petId, @RequestBody Pet updatePet) {
        return new ResponseEntity<>(petService.updatePet(petId, updatePet), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePet/{petId}")
    public void deletePet(@PathVariable Long petId) {
        petService.deletePet(petId);
    }
}
