package com.proyecto.citas.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.citas.model.Appointment;
import com.proyecto.citas.model.Medic;
import com.proyecto.citas.model.Patient;
import com.proyecto.citas.repository.AppointmentRepository;
import com.proyecto.citas.repository.MedicRepository;
import com.proyecto.citas.repository.PatientRepository;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicRepository medicRepository;

    public boolean deleteAppointment(Long id) {
        try {
            appointmentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment addAppointment(Appointment appointmentRequest) {
        Appointment appointment = new Appointment();
        appointment.setDate(appointmentRequest.getDate());
        appointment.setDetails(appointmentRequest.getDetails());
        appointment.setStatus(appointmentRequest.getStatus());

        Optional<Patient> patientOptional = patientRepository.findById(appointmentRequest.getPatient().getId());
        Optional<Medic> medicOptional = medicRepository.findById(appointmentRequest.getMedic().getId());

        if (patientOptional.isPresent() && medicOptional.isPresent()) {
            appointment.setPatient(patientOptional.get());
            appointment.setMedic(medicOptional.get());
            return appointmentRepository.save(appointment);
        } else {
            throw new IllegalArgumentException("Patient or Medic not found!");
        }
    }

    public Appointment updateAppointment(Long id, Appointment appointmentRequest) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            appointment.setDate(appointmentRequest.getDate());
            appointment.setDetails(appointmentRequest.getDetails());
            appointment.setStatus(appointmentRequest.getStatus());

            Optional<Patient> patientOptional = patientRepository.findById(appointmentRequest.getPatient().getId());
            Optional<Medic> medicOptional = medicRepository.findById(appointmentRequest.getMedic().getId());

            if (patientOptional.isPresent() && medicOptional.isPresent()) {
                appointment.setPatient(patientOptional.get());
                appointment.setMedic(medicOptional.get());
                return appointmentRepository.save(appointment);
            } else {
                throw new IllegalArgumentException("Patient or Medic not found!");
            }
        } else {
            throw new IllegalArgumentException("Appointment not found!");
        }
    }

    public List<Appointment> getPendingAppointmentsByPatient(Long patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            return appointmentRepository.findByPatientAndStatus(patientOptional.get(), "pending");
        } else {
            throw new IllegalArgumentException("Patient not found!");
        }
    }

    public List<Appointment> getPendingAppointmentsByMedicAndDate(Long medicId, Date date) {
        Optional<Medic> medicOptional = medicRepository.findById(medicId);
        if (medicOptional.isPresent()) {
            return appointmentRepository.findByMedicAndDateAndStatus(medicOptional.get(), date, "pending");
        } else {
            throw new IllegalArgumentException("Medic not found!");
        }
    }
}
