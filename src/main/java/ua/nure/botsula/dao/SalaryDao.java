package ua.nure.botsula.dao;

import net.proselyte.springsecurityapp.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alexandr on 14.06.2017.
 */
public interface SalaryDao extends JpaRepository<Salary, Long> {
    Salary findSalaryById(Long id);
}
