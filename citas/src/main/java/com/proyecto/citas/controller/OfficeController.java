package com.proyecto.citas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.citas.model.Office;
import com.proyecto.citas.service.OfficeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @GetMapping
    public List<Office> showOffices() {
        return officeService.getOffices();
    }

    @PostMapping
    public Office insert(@RequestBody Office office) {
        return officeService.save(office);
    }

    @PutMapping
    public Office edit(@RequestBody Office office) {
        return officeService.save(office);
    }

    @DeleteMapping(value = "/{id}")
    public boolean delete(@PathVariable Long id) {
        return officeService.delete(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Office> getOfficeById(@PathVariable Long id) {
        Optional<Office> optionalOffice = officeService.findOfficeById(id);
        if (optionalOffice.isPresent()) {
            return new ResponseEntity<>(optionalOffice.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
