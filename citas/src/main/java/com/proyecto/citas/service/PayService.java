package com.proyecto.citas.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.citas.model.Pay;
import com.proyecto.citas.model.Patient;
import com.proyecto.citas.repository.PayRepository;

@Service
public class PayService {

    @Autowired
    PayRepository payRepository;

    public ArrayList<Pay> getAllPayments() {
        return (ArrayList<Pay>) payRepository.findAll();
    }

    public Pay save(Pay pay) {
        return payRepository.save(pay);
    }

    public Pay update(Long id, Pay pay) {
        Optional<Pay> existingPayOptional = payRepository.findById(id);
        if (existingPayOptional.isPresent()) {
            Pay existingPay = existingPayOptional.get();
            existingPay.setType(pay.getType());
            existingPay.setAmount(pay.getAmount());
            existingPay.setDate(pay.getDate());
            existingPay.setPatient(pay.getPatient());
            return payRepository.save(existingPay);
        } else {
            throw new RuntimeException("Pay not found with id " + id);
        }
    }

    public boolean delete(Long id) {
        try {
            payRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Pay> getPaymentsForPatientInPeriod(Patient patient, Date startDate, Date endDate) {
        return payRepository.findByPatientAndDateBetween(patient, startDate, endDate);
    }
}
