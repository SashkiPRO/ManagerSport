package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.model.BankAccount;

import java.util.List;

/**
 * Created by Alexandr on 14.06.2017.
 */
public interface BankAccountService {
    void save(BankAccount bankAccount);
    List<BankAccount> findAll();

}
