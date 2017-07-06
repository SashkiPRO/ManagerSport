package ua.nure.botsula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.botsula.dao.PaymentDao;
import ua.nure.botsula.model.Payment;

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
