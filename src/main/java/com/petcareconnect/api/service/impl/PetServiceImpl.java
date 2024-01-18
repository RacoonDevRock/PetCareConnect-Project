package com.petcareconnect.api.service.impl;

import com.petcareconnect.api.exception.NoResourceFoundException;
import com.petcareconnect.api.exception.NoSuchElementException;
import com.petcareconnect.api.model.Owner;
import com.petcareconnect.api.model.Pet;
import com.petcareconnect.api.repository.OwnerRepository;
import com.petcareconnect.api.repository.PetRepository;
import com.petcareconnect.api.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements IPetService {
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Pet createPet(Long ownerId, Pet pet) {
        Optional<Owner> ownerOptional = ownerRepository.findById(ownerId);

        if (ownerOptional.isPresent()) {
            Owner owner = ownerOptional.get();
            pet.setOwner(owner);
            return petRepository.save(pet);
        } else {
            throw new NoSuchElementException("Not founded owner with ID:" + ownerId);
        }
    }

    @Override
    public Optional<Pet> getPetByName(String petName) {
        return Optional.of(
                petRepository.findPetByPetName(petName)
                        .orElseThrow(() -> new NoResourceFoundException("Not founded pet with name: "+petName)));
    }

    @Override
    public List<Pet> getAllPetsByOwner(String username) {
        List<Pet> pets = petRepository.findPetsByOwnerUsername(username);
        if (pets.isEmpty()) {
            throw new NoResourceFoundException("No pets found for owner with username: " + username);
        }
        return pets;
    }

    @Override
    public Pet updatePet(Long petId, Pet updatedPet) {
        Optional<Pet> existsPet = petRepository.findById(petId);

        if (existsPet.isPresent()) {
            updatedPet.setPetId(existsPet.get().getPetId());
            updatedPet.setOwner(existsPet.get().getOwner());
            return petRepository.save(updatedPet);
        } else {
            throw new NoSuchElementException("Not founded pet with ID: " + petId);
        }
    }

    @Override
    public void deletePet(Long petId) {
        petRepository.deleteById(petId);
    }
}
