package com.petcareconnect.api.service.impl;

import com.petcareconnect.api.model.Reminder;
import com.petcareconnect.api.repository.ReminderRepository;
import com.petcareconnect.api.service.IReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderServiceImpl implements IReminderService {
    private final ReminderRepository reminderRepository;

    @Autowired
    public ReminderServiceImpl(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    @Override
    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    @Override
    public Optional<Reminder> getReminderById(Long reminderId) {
        return reminderRepository.findById(reminderId);
    }

    @Override
    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    @Override
    public Reminder updateReminder(Long reminderId, Reminder updateReminder) {
        Optional<Reminder> existsReminder = reminderRepository.findById(reminderId);

        if (existsReminder.isPresent()) {
            updateReminder.setReminderId(existsReminder.get().getReminderId());
            return reminderRepository.save(updateReminder);
        } else {
            return null;
        }
    }

    @Override
    public void deleteReminder(Long reminderId) {
        reminderRepository.deleteById(reminderId);
    }
}
