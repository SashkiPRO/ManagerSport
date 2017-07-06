package ua.nure.botsula.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.botsula.model.User;
import ua.nure.botsula.service.UserService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Alexandr on 11.06.2017.
 */
@Component
public class EventPropertiesEditor extends PropertyEditorSupport {
    @Autowired
    private UserService userService;

    @Override
    public void setAsText(String id){
        User user = userService.findById(Long.parseLong(id));

        setValue(user);
    }
    @Override
    public String getAsText(){
        User user =(User)this.getValue();
        return user.getId().toString();
    }
}
