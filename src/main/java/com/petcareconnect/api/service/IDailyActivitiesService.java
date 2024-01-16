package com.petcareconnect.api.service;

import com.petcareconnect.api.model.DailyActivity;

import java.util.List;
import java.util.Optional;

public interface IDailyActivitiesService {
    DailyActivity createActivity(DailyActivity dailyActivity);
    Optional<DailyActivity> getActivityById(Long activityId);
    List<DailyActivity> getAllActivities();
    DailyActivity updateActivity(Long activityId, DailyActivity dailyActivity);
    void deleteActivity(Long activityId);
}
