package com.example.matchmaker.controller;

import com.example.matchmaker.model.Patient;
import com.example.matchmaker.model.PatientDTO;
import com.example.matchmaker.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchesController {

    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patients")
    public List<Patient> getAllPatients()
    {
        return patientRepository.findAll();
    }

    @PostMapping("/patients/add")
    public ResponseEntity<String> addPatient(@RequestBody PatientDTO patientDTO)
    {
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setNeed(patientDTO.getNeed());

        patientRepository.save(patient);

        return ResponseEntity.ok("Patient added");
    }

}
