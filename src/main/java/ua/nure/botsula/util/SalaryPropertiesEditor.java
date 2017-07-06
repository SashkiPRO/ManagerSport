package ua.nure.botsula.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.botsula.model.Salary;
import ua.nure.botsula.service.SalaryService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Alexandr on 15.06.2017.
 */
@Component
public class SalaryPropertiesEditor extends PropertyEditorSupport {
    @Autowired
    private SalaryService salaryService;

    @Override
    public void setAsText(String id){
        Salary salary= salaryService.findSalaryById(Long.parseLong(id));
        setValue(salary);
    }

}
