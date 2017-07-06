package ua.nure.botsula.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.botsula.model.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findByLogin(String login);
    User findById(Long id);
}
