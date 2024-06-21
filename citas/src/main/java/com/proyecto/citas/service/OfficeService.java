package com.proyecto.citas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.citas.model.Office;
import com.proyecto.citas.repository.OfficeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    public List<Office> getOffices() {
        return officeRepository.findAll();
    }

    public Office save(Office office) {
        return officeRepository.save(office);
    }

    public boolean delete(Long id) {
        try {
            officeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<Office> findOfficeById(Long id) {
        return officeRepository.findById(id);
    }
}
