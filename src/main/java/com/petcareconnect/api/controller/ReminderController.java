package com.petcareconnect.api.controller;

import com.petcareconnect.api.model.Reminder;
import com.petcareconnect.api.service.IReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminder")
public class ReminderController {
    private final IReminderService reminderService;

    @Autowired
    public ReminderController(IReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @PostMapping("/create")
    public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder) {
        return new ResponseEntity<>(reminderService.createReminder(reminder), HttpStatus.CREATED);
    }

    @GetMapping("/{reminderId}")
    public ResponseEntity<?> getReminderId(@PathVariable Long reminderId) {
        return new ResponseEntity<>(reminderService.getReminderById(reminderId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reminder>> getAllReminders() {
        return new ResponseEntity<>(reminderService.getAllReminders(), HttpStatus.OK);
    }

    @PutMapping("/updateReminder/{reminderId}")
    public ResponseEntity<Reminder> updateReminder(@PathVariable Long reminderId, @RequestBody Reminder reminder) {
        return new ResponseEntity<>(reminderService.updateReminder(reminderId, reminder), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteReminder/{reminderId}")
    public void deleteReminder(@PathVariable Long reminderId) {
        reminderService.deleteReminder(reminderId);
    }
}
