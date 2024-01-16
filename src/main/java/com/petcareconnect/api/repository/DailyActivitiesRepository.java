package com.petcareconnect.api.repository;


import com.petcareconnect.api.model.DailyActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyActivitiesRepository extends JpaRepository<DailyActivities, Long> {
}
