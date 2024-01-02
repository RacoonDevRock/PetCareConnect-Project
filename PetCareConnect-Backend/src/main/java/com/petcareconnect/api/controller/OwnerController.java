package com.petcareconnect.api.controller;

import com.petcareconnect.api.dto.OwnerDTO;
import com.petcareconnect.api.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {
    private final IOwnerService iOwnerService;

    @Autowired
    public OwnerController(IOwnerService iOwnerService) {
        this.iOwnerService = iOwnerService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllOwners() {
        return ResponseEntity.ok(iOwnerService.findAllOwners());
    }

    @PostMapping("/signup")
    public ResponseEntity<?> singUpOwner(@RequestBody OwnerDTO ownerDTO) throws URISyntaxException {
        OwnerDTO ownerCreated = iOwnerService.signUpOwner(ownerDTO);
        return ResponseEntity.created(new URI("/api/owner/signup")).body(ownerCreated.getUsername());
    }

    @PutMapping("/update/{ownerId}")
    public ResponseEntity<String> updateOwner(@PathVariable Long ownerId, @RequestBody OwnerDTO ownerDTO) {
        iOwnerService.updateOwnerById(ownerId, ownerDTO);
        String response = "Update successfully Owner with ID: " + ownerId;
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{ownerId}")
    public ResponseEntity<?> deleteOwner(@PathVariable Long ownerId) {
        iOwnerService.deleteOwnerById(ownerId);
        return ResponseEntity.ok("Owner successfully deleted!");
    }
}
