package com.petcareconnect.api.repository;

import com.petcareconnect.api.model.HistoryMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryMedicalRepository extends JpaRepository<HistoryMedical, Long> {
}
