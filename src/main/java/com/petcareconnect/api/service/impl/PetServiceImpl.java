package com.petcareconnect.api.service.impl;

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
            // TODO: HANDLE EXCEPTION
            return  null;
        }
    }

    @Override
    public Optional<Pet> getPetById(Long petId) {
        return petRepository.findById(petId);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet updatePet(Long petId, Pet updatedPet) {
        Optional<Pet> existsPet = petRepository.findById(petId);

        if (existsPet.isPresent()) {
            updatedPet.setPetId(existsPet.get().getPetId());
            updatedPet.setOwner(existsPet.get().getOwner());
            return petRepository.save(updatedPet);
        } else {
            // TODO: HANDLE EXCEPTION
            return null;
        }
    }

    @Override
    public void deletePet(Long petId) {
        petRepository.deleteById(petId);
    }
}
