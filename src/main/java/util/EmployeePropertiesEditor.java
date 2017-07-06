package util;

import net.proselyte.springsecurityapp.model.User;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
