package ua.nure.botsula.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.botsula.model.Salary;

/**
 * Created by Alexandr on 14.06.2017.
 */
public interface SalaryDao extends JpaRepository<Salary, Long> {
    Salary findSalaryById(Long id);
}
