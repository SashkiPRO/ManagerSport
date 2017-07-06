package ua.nure.botsula.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.botsula.model.Payment;

/**
 * Created by Alexandr on 16.06.2017.
 */
public interface PaymentDao extends JpaRepository<Payment, Long> {
}
