package ua.nure.botsula.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.botsula.model.Role;
import ua.nure.botsula.service.RoleService;

/**
 * Created by Alexandr on 05.06.2017.
 */
@Component
public class RolePropetiesEditor extends PropertiesEditor {
   @Autowired
   private RoleService roleService;

    @Override
    public void setAsText(String id){
       Role role = roleService.findRoleById(Long.parseLong(id));

        setValue(role);
    }
    @Override
    public String getAsText(){
        Role role =(Role)this.getValue();
        return role.getId().toString();
    }
}
