package com.petcareconnect.api.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    Long petId;

    @Column(name = "pet_name")
    String petName;
    String species;
    String breed;

    @Column(name = "date_birth")
    Date dateBirth;

    @ManyToOne(targetEntity = Owner.class)
    @JoinColumn(name = "owner_id")
    Owner owner;

    @OneToMany(targetEntity = HistoryMedical.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<HistoryMedical> historyMedicals;

    @OneToMany(targetEntity = Reminder.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Reminder> reminders;

    @OneToMany(targetEntity = DailyActivities.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<DailyActivities> activities;
}
