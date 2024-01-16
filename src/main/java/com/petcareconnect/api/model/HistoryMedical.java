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
@Table(name = "history_medical")
public class HistoryMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "disease_type")
    private String diseaseType;

    @Column(name = "date_diagnosis")
    private Date dateDiagnosis;
    private String treatment;

//    @ManyToOne(targetEntity = Pet.class)
//    @JoinColumn(name = "pet_id")
//    private Pet pet;
}
