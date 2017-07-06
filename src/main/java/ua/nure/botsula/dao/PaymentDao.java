package ua.nure.botsula.dao;

import net.proselyte.springsecurityapp.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alexandr on 16.06.2017.
 */
public interface PaymentDao extends JpaRepository<Payment, Long> {
}
