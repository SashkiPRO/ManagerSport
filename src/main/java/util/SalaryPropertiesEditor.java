package util;

import net.proselyte.springsecurityapp.model.Salary;
import net.proselyte.springsecurityapp.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
