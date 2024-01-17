package com.petcareconnect.api.service;

import com.petcareconnect.api.model.HistoryMedical;

import java.util.List;
import java.util.Optional;

public interface IHistoryMedicalService {
    HistoryMedical createHistoryMedical(Long petId, HistoryMedical historyMedical);
    Optional<HistoryMedical> getHistoryMedicalById(Long recordId);
    List<HistoryMedical> getAllHistories();
    HistoryMedical updateHistory(Long recordId, HistoryMedical updateMedical);
    void deleteById(Long recordId);
}
