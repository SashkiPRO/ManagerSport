package ua.nure.botsula.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.botsula.model.User;
import ua.nure.botsula.service.UserService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Alexandr on 14.06.2017.
 */
@Component
public class EmployeePropertiesEditor extends PropertyEditorSupport {
    @Autowired
    private UserService userService;

    @Override
    public void setAsText(String id){
        User user = userService.findById(Long.parseLong(id));

        setValue(user);
    }
}
