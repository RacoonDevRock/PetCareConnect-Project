package com.petcareconnect.api.controller;

import com.petcareconnect.api.model.HistoryMedical;
import com.petcareconnect.api.service.IHistoryMedicalService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "History Medical", description = "History Medical management APIs")
@RestController
@RequestMapping("/medical")
public class HistoryMedicalController {
    private final IHistoryMedicalService medicalService;

    @Autowired
    public HistoryMedicalController(IHistoryMedicalService medicalService) {
        this.medicalService = medicalService;
    }

    @PostMapping("/create/{petId}")
    public ResponseEntity<HistoryMedical> createMedical(@PathVariable Long petId, @RequestBody HistoryMedical historyMedical){
        medicalService.createHistoryMedical(petId, historyMedical);
        return ResponseEntity.ok(historyMedical);
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<?> getMedicalById(@PathVariable Long recordId) {
        medicalService.getHistoryMedicalById(recordId);
        return ResponseEntity.ok("");
    }

    @PutMapping("/updatedMedical/{recordId}")
    public ResponseEntity<HistoryMedical> updateMedical(@PathVariable Long recordId, @RequestBody HistoryMedical updateMedical) {
        medicalService.updateHistory(recordId, updateMedical);
        return ResponseEntity.ok(updateMedical);
    }

    @DeleteMapping("/deleteMedical/{recordId}")
    public void deleteMedical(@PathVariable Long recordId) {
        medicalService.deleteById(recordId);
    }
}
