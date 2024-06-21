package com.proyecto.citas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.citas.model.Medic;
import com.proyecto.citas.repository.MedicRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicService {

    @Autowired
    MedicRepository medicRepository;

    public List<Medic> getMedics() {
        return medicRepository.findAll();
    }

    public Medic save(Medic medic) {
        return medicRepository.save(medic);
    }

    public boolean delete(Long id) {
        try {
            medicRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<Medic> findMedicById(Long id) {
        return medicRepository.findById(id);
    }
}
