package com.proyecto.citas.repository;

import com.proyecto.citas.model.Pay;
import com.proyecto.citas.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PayRepository extends JpaRepository<Pay, Long> {
    List<Pay> findByPatientAndDateBetween(Patient patient, Date startDate, Date endDate);
}
