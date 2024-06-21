package com.proyecto.citas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.citas.model.Pay;
import com.proyecto.citas.model.Patient;
import com.proyecto.citas.service.PayService;

@RestController
@RequestMapping("/pays")
public class PayController {

    @Autowired
    private PayService payService;

    @GetMapping
    public ResponseEntity<List<Pay>> getAllPayments() {
        List<Pay> payments = payService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pay> createPay(@RequestBody Pay pay) {
        Pay createdPay = payService.save(pay);
        return new ResponseEntity<>(createdPay, HttpStatus.CREATED);
    }

    @GetMapping("/patient/{patientId}/period")
    public List<Pay> getPaymentsForPatientInPeriod(@PathVariable Long patientId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        Patient patient = new Patient();
        patient.setId(patientId);
        return payService.getPaymentsForPatientInPeriod(patient, startDate, endDate);
    }

}
