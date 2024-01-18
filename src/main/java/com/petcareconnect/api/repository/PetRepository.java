package com.petcareconnect.api.repository;

import com.petcareconnect.api.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findPetByPetName(String petName);
    List<Pet> findPetsByOwnerUsername(String username);
}
