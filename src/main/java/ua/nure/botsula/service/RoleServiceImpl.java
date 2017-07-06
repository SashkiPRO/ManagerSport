package ua.nure.botsula.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.botsula.dao.RoleDao;
import ua.nure.botsula.model.Role;

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
