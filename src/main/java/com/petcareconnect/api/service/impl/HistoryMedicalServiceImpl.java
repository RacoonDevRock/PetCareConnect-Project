package com.petcareconnect.api.service.impl;

import com.petcareconnect.api.exception.NoResourceFoundException;
import com.petcareconnect.api.exception.NoSuchElementException;
import com.petcareconnect.api.model.HistoryMedical;
import com.petcareconnect.api.model.Pet;
import com.petcareconnect.api.repository.HistoryMedicalRepository;
import com.petcareconnect.api.repository.PetRepository;
import com.petcareconnect.api.service.IHistoryMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HistoryMedicalServiceImpl implements IHistoryMedicalService {
    private final HistoryMedicalRepository medicalRepository;
    private final PetRepository petRepository;

    @Autowired
    public HistoryMedicalServiceImpl(HistoryMedicalRepository medicalRepository, PetRepository petRepository) {
        this.medicalRepository = medicalRepository;
        this.petRepository = petRepository;
    }

    @Override
    public HistoryMedical createHistoryMedical(Long petId, HistoryMedical historyMedical) {
        Optional<Pet> petOptional = petRepository.findById(petId);

        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();
            historyMedical.setPet(pet);
            return medicalRepository.save(historyMedical);
        } else {
            throw new NoResourceFoundException("Not found pet with ID: "+petId);
        }
    }

    @Override
    public Optional<HistoryMedical> getHistoryMedicalById(Long recordId) {
        return Optional.of(
                medicalRepository.findById(recordId)
                        .orElseThrow(() -> new NoResourceFoundException("Not founded record with ID: "+recordId)));
    }

    @Override
    public HistoryMedical updateHistory(Long recordId, HistoryMedical updateMedical) {
        Optional<HistoryMedical> existsMedical = medicalRepository.findById(recordId);

        if (existsMedical.isPresent()) {
            updateMedical.setRecordId(existsMedical.get().getRecordId());
            return medicalRepository.save(updateMedical);
        } else {
            throw new NoSuchElementException("Not found record with ID: " + recordId);
        }
    }

    @Override
    public void deleteById(Long recordId) {
        medicalRepository.deleteById(recordId);
    }
}
