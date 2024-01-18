package com.petcareconnect.api.service;

import com.petcareconnect.api.model.Pet;

import java.util.List;
import java.util.Optional;

public interface IPetService {

    Pet createPet(Long ownerId, Pet Pet);

    Optional<Pet> getPetByName(String petName); // buscar por id o nombre

    List<Pet> getAllPetsByOwner(String username); // todos en base a un usuario nombre

    Pet updatePet(Long petId, Pet updatedPet); // por id o nombre

    void deletePet(Long petId); // por id o nombre
}
