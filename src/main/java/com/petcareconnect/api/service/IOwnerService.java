package com.petcareconnect.api.service;

import com.petcareconnect.api.model.Owner;

import java.util.List;
import java.util.Optional;

public interface IOwnerService {
    Owner createOwner(Owner owner);
    Optional<Owner> viewOwnerProfile(Long ownerId); //buscar por email
    Owner viewProfile(Long ownerId);
    Owner updateProfile(Long ownerId, Owner updatedOwner);
    List<Owner> findAll();
}
