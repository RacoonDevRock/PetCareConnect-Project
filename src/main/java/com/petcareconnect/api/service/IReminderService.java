package com.petcareconnect.api.service;

import com.petcareconnect.api.model.Reminder;

import java.util.List;
import java.util.Optional;

public interface IReminderService {
    Reminder createReminder(Reminder reminder);
    Optional<Reminder> getReminderById(Long reminderId);
    List<Reminder> getAllReminders();
    Reminder updateReminder(Long reminderId, Reminder updateReminder);
    void deleteReminder(Long reminderId);
}
