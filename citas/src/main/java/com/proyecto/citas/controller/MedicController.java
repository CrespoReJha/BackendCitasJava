package com.proyecto.citas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.citas.model.Medic;
import com.proyecto.citas.service.MedicService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medics")
public class MedicController {

    @Autowired
    private MedicService medicService;

    @GetMapping
    public List<Medic> showMedics() {
        return medicService.getMedics();
    }

    @PostMapping
    public Medic insert(@RequestBody Medic medic) {
        return medicService.save(medic);
    }

    @PutMapping
    public Medic edit(@RequestBody Medic medic) {
        return medicService.save(medic);
    }

    @DeleteMapping(value = "/{id}")
    public boolean delete(@PathVariable Long id) {
        return medicService.delete(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Medic> getMedicById(@PathVariable Long id) {
        Optional<Medic> optionalMedic = medicService.findMedicById(id);
        if (optionalMedic.isPresent()) {
            return new ResponseEntity<>(optionalMedic.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
