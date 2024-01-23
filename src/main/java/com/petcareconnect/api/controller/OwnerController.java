package com.petcareconnect.api.controller;

import com.petcareconnect.api.dto.OwnerDTO;
import com.petcareconnect.api.exception.NoSuchElementException;
import com.petcareconnect.api.model.Owner;
import com.petcareconnect.api.service.IOwnerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Owner", description = "Owner management APIs")
@RestController
@RequestMapping("/owner")
public class OwnerController {
    private final IOwnerService ownerService;

    @Autowired
    public OwnerController(IOwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/create")
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody Owner owner) {
        Owner createdOwner = ownerService.createOwner(owner);

        OwnerDTO ownerDTO = OwnerDTO.builder()
                .username(createdOwner.getUsername())
                .email(createdOwner.getEmail())
                .build();

        return new ResponseEntity<>(ownerDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerDTO> getOwnerId(@PathVariable Long ownerId) {
        OwnerDTO ownerDTO = ownerService.viewOwnerProfile(ownerId)
                .map(OwnerDTO::fromEntity) // Convierte Owner a OwnerDTO
                .orElseThrow(() -> new NoSuchElementException("Not found owner with ID:" + ownerId));

        return ResponseEntity.ok(ownerDTO);
    }

    @GetMapping("/myProfile/{ownerId}")
    public ResponseEntity<Owner> viewMyProfile(@PathVariable Long ownerId) {
        Owner owner = ownerService.viewProfile(ownerId);
        return ResponseEntity.ok(owner);
    }

    @PutMapping("/updateOwner/{ownerId}")
    public ResponseEntity<OwnerDTO> updateOwner(@PathVariable Long ownerId, @RequestBody Owner owner) {
        Owner updatedOwner = ownerService.updateProfile(ownerId, owner);

        OwnerDTO ownerDTO = OwnerDTO.builder()
                .username(updatedOwner.getUsername())
                .email(updatedOwner.getEmail())
                .build();

        return ResponseEntity.ok(ownerDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Owner>> allOwners() {
        List<Owner> owners = ownerService.findAll();
        return ResponseEntity.ok(owners);
    }
}