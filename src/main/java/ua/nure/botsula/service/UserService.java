package ua.nure.botsula.service;


import ua.nure.botsula.model.User;

import java.util.List;

/**
 * Service class for {@link ua.nure.botsula.model.User}
 *
 * @author Aleksandr Botsula
 * @version 1.0
 */

public interface UserService {

    void save(User user);

    User findByLogin(String login);

    User findById(Long id);
    List<User> findAll();
    void update(User user);
}
