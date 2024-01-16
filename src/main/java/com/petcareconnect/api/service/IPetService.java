package com.petcareconnect.api.service;

import com.petcareconnect.api.model.Pet;

import java.util.List;
import java.util.Optional;

public interface IPetService {

    //    CRUD
    Pet createPet(Pet Pet);

    Optional<Pet> getPetById(Long petId);

    List<Pet> getAllPets();

    Pet updatePet(Long petId, Pet updatedPet);

    void deletePet(Long petId);
}
