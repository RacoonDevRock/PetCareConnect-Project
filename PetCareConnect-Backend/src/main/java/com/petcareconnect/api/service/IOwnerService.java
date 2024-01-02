package com.petcareconnect.api.service;

import com.petcareconnect.api.dto.OwnerDTO;

import java.util.List;

public interface IOwnerService {
    OwnerDTO signUpOwner(OwnerDTO ownerDTO);
    void updateOwnerById(Long ownerId, OwnerDTO ownerDTO);
    void deleteOwnerById(Long ownerId);
    List<OwnerDTO> findAllOwners();
}
