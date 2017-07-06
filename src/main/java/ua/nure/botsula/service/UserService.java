package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.model.User;

import java.util.List;

/**
 * Service class for {@link net.proselyte.springsecurityapp.model.User}
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public interface UserService {

    void save(User user);

    User findByLogin(String login);

    User findById(Long id);
    List<User> findAll();
    void update(User user);
}
