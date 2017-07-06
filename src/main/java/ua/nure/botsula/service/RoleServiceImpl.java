package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.dao.RoleDao;
import net.proselyte.springsecurityapp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Alexandr on 05.06.2017.
 */
@Component
public class RoleServiceImpl implements RoleService {
@Autowired
    private RoleDao roleDao;


    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findRoleById(Long id) {
        return roleDao.findRoleById(id);
    }
}
