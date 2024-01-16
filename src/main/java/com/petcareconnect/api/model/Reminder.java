package com.petcareconnect.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reminder")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reminder_id")
    private Long reminderId;

    @Column(name = "reminder_type")
    private String reminderType;

    @Column(name = "reminder_date")
    private Date reminderDate;
    private String description;

    @ManyToOne(targetEntity = Pet.class)
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
