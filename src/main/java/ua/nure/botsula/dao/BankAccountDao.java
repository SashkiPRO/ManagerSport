package ua.nure.botsula.dao;

import net.proselyte.springsecurityapp.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alexandr on 14.06.2017.
 */
public interface BankAccountDao extends JpaRepository<BankAccount, Long> {
}
