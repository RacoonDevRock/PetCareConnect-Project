package com.petcareconnect.api.service.impl;

import com.petcareconnect.api.model.Pet;
import com.petcareconnect.api.repository.PetRepository;
import com.petcareconnect.api.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements IPetService {
    private final PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
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
            return petRepository.save(updatedPet);
        } else {
            return null;
        }
    }

    @Override
    public void deletePet(Long petId) {
        petRepository.deleteById(petId);
    }
}
