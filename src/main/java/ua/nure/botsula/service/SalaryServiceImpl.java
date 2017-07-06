package ua.nure.botsula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.botsula.dao.SalaryDao;
import ua.nure.botsula.model.Salary;

import java.util.List;

/**
 * Created by Alexandr on 14.06.2017.
 */
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryDao salaryDao;

    @Override
    public void save(Salary salary) {
        salaryDao.save(salary);
    }

    @Override
    public List<Salary> findAll() {
        return salaryDao.findAll();
    }

    @Override
    public void delete(Salary salary) {
salaryDao.delete(salary);
    }

    @Override
    public Salary findSalaryById(Long id) {
        return salaryDao.findSalaryById(id);
    }

    @Override
    public void save(List<Salary> salaries) {
        salaryDao.save(salaries);
    }
}
