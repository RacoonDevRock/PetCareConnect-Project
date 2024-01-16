package com.petcareconnect.api.service.impl;

import com.petcareconnect.api.model.HistoryMedical;
import com.petcareconnect.api.repository.HistoryMedicalRepository;
import com.petcareconnect.api.service.IHistoryMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryMedicalServiceImpl implements IHistoryMedicalService {
    private final HistoryMedicalRepository medicalRepository;

    @Autowired
    public HistoryMedicalServiceImpl(HistoryMedicalRepository medicalRepository) {
        this.medicalRepository = medicalRepository;
    }

    @Override
    public HistoryMedical createHistoryMedical(HistoryMedical historyMedical) {
        return medicalRepository.save(historyMedical);
    }

    @Override
    public Optional<HistoryMedical> getHistoryMedicalById(Long recordId) {
        return medicalRepository.findById(recordId);
    }

    @Override
    public List<HistoryMedical> getAllHistories() {
        return medicalRepository.findAll();
    }

    @Override
    public HistoryMedical updateHistory(Long recordId, HistoryMedical updateMedical) {
        Optional<HistoryMedical> existsMedical = medicalRepository.findById(recordId);

        if (existsMedical.isPresent()) {
            updateMedical.setRecordId(existsMedical.get().getRecordId());
            return medicalRepository.save(updateMedical);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long recordId) {
        medicalRepository.deleteById(recordId);
    }
}
