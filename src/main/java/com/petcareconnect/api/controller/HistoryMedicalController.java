package com.petcareconnect.api.controller;

import com.petcareconnect.api.model.HistoryMedical;
import com.petcareconnect.api.service.IHistoryMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical")
public class HistoryMedicalController {
    private final IHistoryMedicalService medicalService;

    @Autowired
    public HistoryMedicalController(IHistoryMedicalService medicalService) {
        this.medicalService = medicalService;
    }

    @PostMapping("/create")
    public ResponseEntity<HistoryMedical> createMedical(@RequestBody HistoryMedical historyMedical){
        return new ResponseEntity<>(medicalService.createHistoryMedical(historyMedical), HttpStatus.CREATED);
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<?> getMedicalById(@PathVariable Long recordId) {
        return new ResponseEntity<>(medicalService.getHistoryMedicalById(recordId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HistoryMedical>> getAllMedicals() {
        return new ResponseEntity<>(medicalService.getAllHistories(), HttpStatus.OK);
    }

    @PutMapping("/updatedMedical/{recordId}")
    public ResponseEntity<HistoryMedical> updateMedical(@PathVariable Long recordId, @RequestBody HistoryMedical updateMedical) {
        return new ResponseEntity<>(medicalService.updateHistory(recordId, updateMedical), HttpStatus.CREATED);
    }

    @DeleteMapping("/{recordId}")
    public void deleteMedical(@PathVariable Long recordId) {
        medicalService.deleteById(recordId);
    }
}
