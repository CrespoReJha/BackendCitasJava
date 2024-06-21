package com.proyecto.citas.repository;

import com.proyecto.citas.model.Appointment;
import com.proyecto.citas.model.Medic;
import com.proyecto.citas.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientAndStatus(Patient patient, String status);

    List<Appointment> findByMedicAndDateAndStatus(Medic medic, Date date, String status);
}
