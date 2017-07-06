package ua.nure.botsula.service;



import ua.nure.botsula.model.Role;

import java.util.List;

/**
 * Created by Alexandr on 05.06.2017.
 */
public interface RoleService {
    List<Role> findAll();
    Role findRoleById(Long id);

}
