package ua.nure.botsula.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.botsula.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
    Role findRoleById(Long id);
}
