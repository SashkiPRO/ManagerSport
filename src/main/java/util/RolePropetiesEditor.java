package util;


import net.proselyte.springsecurityapp.model.Role;
import net.proselyte.springsecurityapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
