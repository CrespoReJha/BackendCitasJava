package com.proyecto.citas.controller;

import java.util.ArrayList;
import java.util.Optional; // Para el método getPatientById

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.citas.service.PatientService;
import com.proyecto.citas.model.Patient;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ArrayList<Patient> showPatients() {
        return patientService.getPatients();
    }

    @PostMapping
    public Patient insert(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @PutMapping
    public Patient edit(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @DeleteMapping(value = "/{id}")
    public boolean delete(@PathVariable Long id) {
        return patientService.delete(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> optionalPatient = patientService.findPatientById(id);
        if (optionalPatient.isPresent()) {
            return new ResponseEntity<>(optionalPatient.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
