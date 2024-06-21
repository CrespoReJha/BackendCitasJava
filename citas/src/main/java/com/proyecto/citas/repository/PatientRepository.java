package com.proyecto.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.citas.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
