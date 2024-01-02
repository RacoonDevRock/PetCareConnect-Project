package com.petcareconnect.api.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "daily-activities")
@Builder
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
