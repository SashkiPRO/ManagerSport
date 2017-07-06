package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.dao.BankAccountDao;
import net.proselyte.springsecurityapp.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 14.06.2017.
 */
@Service
public class BankAccountServiceImpl implements BankAccountService  {
@Autowired
private BankAccountDao bankAccountDao;
    @Override
    public void save(BankAccount bankAccount) {
        bankAccountDao.save(bankAccount);
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountDao.findAll();
    }
}
