package com.petcareconnect.api.controller;

import com.petcareconnect.api.model.DailyActivity;
import com.petcareconnect.api.service.IDailyActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class DailyActivityController {
    private final IDailyActivitiesService activitiesService;

    @Autowired
    public DailyActivityController(IDailyActivitiesService activitiesService) {
        this.activitiesService = activitiesService;
    }

    @PostMapping("/create")
    public ResponseEntity<DailyActivity> createActivity(@RequestBody DailyActivity dailyActivity) {
        return new ResponseEntity<>(activitiesService.createActivity(dailyActivity), HttpStatus.CREATED);
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<?> getActivityById(@PathVariable Long activityId) {
        return new ResponseEntity<>(activitiesService.getActivityById(activityId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DailyActivity>> getAllActivities() {
        return new ResponseEntity<>(activitiesService.getAllActivities(), HttpStatus.OK);
    }

    @PutMapping("/updateActivity/{activityId}")
    public ResponseEntity<DailyActivity> updateActivity(@PathVariable Long activityId, @RequestBody DailyActivity updateActivity) {
        return new ResponseEntity<>(activitiesService.updateActivity(activityId, updateActivity), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteActivity/{activityId}")
    public void deleteActivity(@PathVariable Long activityId) {
        activitiesService.deleteActivity(activityId);
    }
}
