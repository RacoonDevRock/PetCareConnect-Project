package com.petcareconnect.api.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "daily-activities")
public class DailyActivities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    Long activityId;

    @Column(name = "activity_type")
    String activityType;

    @Column(name = "activity_date")
    LocalDate activityDate;
    Integer duration;

    @ManyToOne(targetEntity = Pet.class)
    @JoinColumn(name = "pet_id")
    Pet pet;
}
