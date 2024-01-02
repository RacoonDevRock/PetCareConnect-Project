package com.petcareconnect.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "history-medical")
@Builder
public class HistoryMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    Long recordId;

    @Column(name = "disease_type")
    String diseaseType;

    @Column(name = "date_diagnosis")
    Date dateDiagnosis;
    String treatment;

    @ManyToOne(targetEntity = Pet.class)
    @JoinColumn(name = "pet_id")
    Pet pet;
}
