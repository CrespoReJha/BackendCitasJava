package com.proyecto.citas.service;

import java.util.Optional; // Para el método findPatientById
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.citas.model.Patient;
import com.proyecto.citas.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public ArrayList<Patient> getPatients() {
        return (ArrayList<Patient>) patientRepository.findAll();
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public boolean delete(Long id) {
        try {
            patientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<Patient> findPatientById(Long id) {
        return patientRepository.findById(id);
    }

}
