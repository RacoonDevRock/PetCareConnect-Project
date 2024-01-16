package com.petcareconnect.api.service;

import com.petcareconnect.api.model.Owner;

import java.util.List;
import java.util.Optional;

public interface IOwnerService {

//    CRUD
    Owner createOwner(Owner owner);

    Optional<Owner> getOwnerById(Long ownerId);

    List<Owner> getAllOwners();

    Owner updateOwner(Long ownerId, Owner updatedOwner);

    void deleteOwner(Long ownerId);
}
