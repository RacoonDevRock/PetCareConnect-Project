package com.petcareconnect.api.controller;

import com.petcareconnect.api.model.Owner;
import com.petcareconnect.api.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    private final IOwnerService ownerService;

    @Autowired
    public OwnerController(IOwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/create")
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        return new ResponseEntity<>(ownerService.createOwner(owner), HttpStatus.CREATED);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<?> getOwnerId(@PathVariable Long ownerId) {
        return new ResponseEntity<>(ownerService.getOwnerById(ownerId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Owner>> getAllOwners() {
        return new ResponseEntity<>(ownerService.getAllOwners(), HttpStatus.OK);
    }

    @PutMapping("/updateOwner/{ownerId}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Long ownerId, @RequestBody Owner owner) {
        return new ResponseEntity<>(ownerService.updateOwner(ownerId,owner), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteOwner/{ownerId}")
    public void deleteOwner(@PathVariable Long ownerId) {
        ownerService.deleteOwner(ownerId);
    }
}
