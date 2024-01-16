package com.petcareconnect.api.repository;


import com.petcareconnect.api.model.DailyActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyActivityRepository extends JpaRepository<DailyActivity, Long> {
}
