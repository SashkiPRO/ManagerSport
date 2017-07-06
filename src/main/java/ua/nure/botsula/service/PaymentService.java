package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.model.Payment;

import java.util.List;

/**
 * Created by Alexandr on 16.06.2017.
 */
public interface PaymentService {
    void save(Payment payment);
    List<Payment> findAll();
 }
