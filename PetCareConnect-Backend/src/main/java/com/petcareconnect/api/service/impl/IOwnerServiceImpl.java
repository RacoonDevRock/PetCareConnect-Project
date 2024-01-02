package com.petcareconnect.api.service.impl;

import com.petcareconnect.api.dto.OwnerDTO;
import com.petcareconnect.api.exception.DataIntegrityViolationException;
import com.petcareconnect.api.exception.NoResourceFoundException;
import com.petcareconnect.api.model.Owner;
import com.petcareconnect.api.repository.OwnerRepository;
import com.petcareconnect.api.service.IOwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IOwnerServiceImpl implements IOwnerService {
    private final OwnerRepository ownerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public IOwnerServiceImpl(OwnerRepository ownerRepository, ModelMapper modelMapper) {
        this.ownerRepository = ownerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OwnerDTO signUpOwner(OwnerDTO ownerDTO) {
        if (ownerRepository.existsByEmail(ownerDTO.getEmail())) {
            throw new DataIntegrityViolationException("Email exists already...");
        }
        Owner owner = modelMapper.map(ownerDTO, Owner.class);
//        Save Owner
        owner = ownerRepository.save(owner);
        return ownerDTO;
    }

    @Override
    public void updateOwnerById(Long ownerId, OwnerDTO ownerDTO) {
        Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);

        if (ownerRepository.findById(ownerId).isPresent()) {
            Owner owner = optionalOwner.get();
            owner.setUsername(ownerDTO.getUsername());
            owner.setEmail(ownerDTO.getEmail());
            owner.setPassword(ownerDTO.getPassword());

            owner = ownerRepository.save(owner);
            modelMapper.map(owner, OwnerDTO.class);
        } else {
            throw new NoResourceFoundException("The Owner does not exist...");
        }
    }

    @Override
    public void deleteOwnerById(Long ownerId) {
        ownerRepository.deleteById(ownerId);
    }

    @Override
    public List<OwnerDTO> findAllOwners() {
        List<Owner> owners = ownerRepository.findAll(); // Obtener todos los propietarios de la base de datos
        return owners.stream()
                .map(owner -> modelMapper.map(owner, OwnerDTO.class)) // Mapear cada Owner a OwnerDTO
                .collect(Collectors.toList()); // Recolectar los elementos en una lista
    }
}
