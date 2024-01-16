package com.petcareconnect.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long petId;

    @Column(name = "pet_name")
    private String petName;
    private String species;
    private String breed;

    @Column(name = "date_birth")
    private Date dateBirth;

    @ManyToOne(targetEntity = Owner.class)
    @JoinColumn(name = "owner_id")
    private Owner owner;

//    @OneToMany(
//            targetEntity = HistoryMedical.class,
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<HistoryMedical> historyMedicalList;
//
//    @OneToMany(
//            targetEntity = Reminder.class,
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<Reminder> reminderList;
//
//    @OneToMany(
//            targetEntity = DailyActivity.class,
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<DailyActivity> dailyActivitiesList;
}
