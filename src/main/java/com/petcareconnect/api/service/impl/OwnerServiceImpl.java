package com.petcareconnect.api.service.impl;

import com.petcareconnect.api.model.Owner;
import com.petcareconnect.api.repository.OwnerRepository;
import com.petcareconnect.api.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements IOwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Optional<Owner> getOwnerById(Long ownerId) {
        return ownerRepository.findById(ownerId);
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner updateOwner(Long ownerId, Owner updatedOwner) {
        Optional<Owner> existOwner =  ownerRepository.findById(ownerId);

        if (existOwner.isPresent()) {
            updatedOwner.setOwnerId(existOwner.get().ownerId);
            return ownerRepository.save(updatedOwner);
        } else {
//            TODO: Make exception
            return null;
        }
    }

    @Override
    public void deleteOwner(Long ownerId) {
        ownerRepository.deleteById(ownerId);
    }
}
