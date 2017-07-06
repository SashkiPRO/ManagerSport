package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.model.Salary;

import java.util.List;

/**
 * Created by Alexandr on 14.06.2017.
 */
public interface SalaryService {
    void save(Salary salary);
    List<Salary> findAll();
    void delete(Salary salary);
    Salary findSalaryById(Long id);
    void save(List<Salary> salaries);
}
