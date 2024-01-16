package com.petcareconnect.api.service.impl;

import com.petcareconnect.api.model.DailyActivity;
import com.petcareconnect.api.repository.DailyActivityRepository;
import com.petcareconnect.api.service.IDailyActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DailyActivityServiceImpl implements IDailyActivitiesService {
    private final DailyActivityRepository dailyActivityRepository;

    @Autowired
    public DailyActivityServiceImpl(DailyActivityRepository dailyActivityRepository) {
        this.dailyActivityRepository = dailyActivityRepository;
    }

    @Override
    public DailyActivity createActivity(DailyActivity dailyActivity) {
        return dailyActivityRepository.save(dailyActivity);
    }

    @Override
    public Optional<DailyActivity> getActivityById(Long activityId) {
        return dailyActivityRepository.findById(activityId);
    }

    @Override
    public List<DailyActivity> getAllActivities() {
        return dailyActivityRepository.findAll();
    }

    @Override
    public DailyActivity updateActivity(Long activityId, DailyActivity updateActivity) {
        Optional<DailyActivity> existsActivity = dailyActivityRepository.findById(activityId);

        if (existsActivity.isPresent()) {
            updateActivity.setActivityId(existsActivity.get().getActivityId());
            return dailyActivityRepository.save(updateActivity);
        } else {
            return null;
        }
    }

    @Override
    public void deleteActivity(Long activityId) {
        dailyActivityRepository.deleteById(activityId);
    }
}
