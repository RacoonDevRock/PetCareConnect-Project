package com.petcareconnect.api.service;

import com.petcareconnect.api.model.Owner;

import java.util.Optional;

public interface IOwnerService {
    Owner createOwner(Owner owner);

    Optional<Owner> viewProfile(Long ownerId); //buscar por email

    Owner updateProfile(Long ownerId, Owner updatedOwner);

//    void deleteOwner(Long ownerId); // solo por admin
}
