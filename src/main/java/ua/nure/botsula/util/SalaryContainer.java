package ua.nure.botsula.util;

import net.proselyte.springsecurityapp.model.Salary;

import java.util.List;

/**
 * Created by Alexandr on 15.06.2017.
 */
public class SalaryContainer {
    private List<Salary> salaryList;

    public List<Salary> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(List<Salary> salaryList) {
        this.salaryList = salaryList;
    }
}
