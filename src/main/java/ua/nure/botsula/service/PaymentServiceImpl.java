package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.dao.PaymentDao;
import net.proselyte.springsecurityapp.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 16.06.2017.
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentDao paymentDao;
    @Override
    public void save(Payment payment) {
        paymentDao.save(payment);
    }

    @Override
    public List<Payment> findAll() {
        return paymentDao.findAll();
    }
}
