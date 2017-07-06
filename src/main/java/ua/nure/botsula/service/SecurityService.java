package ua.nure.botsula.service;

/**
 * Service for Security.
 *
 * @author Aleskandr Botsula
 * @version 1.0
 */

public interface SecurityService {

    String findLoggedInLogin();

    void autoLogin(String login, String password);
}
