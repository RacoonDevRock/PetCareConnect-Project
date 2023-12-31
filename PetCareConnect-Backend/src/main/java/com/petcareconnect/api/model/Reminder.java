package com.petcareconnect.api.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "reminder")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reminder_id")
    Long reminderId;

    @Column(name = "reminder_type")
    String reminderType;

    @Column(name = "reminder_date")
    Date reminderDate;
    String description;

    @ManyToOne(targetEntity = Pet.class)
    @JoinColumn(name = "pet_id")
    Pet pet;
}
