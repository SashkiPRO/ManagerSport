package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.model.Event;
import net.proselyte.springsecurityapp.model.Message;
import net.proselyte.springsecurityapp.model.User;

import java.util.List;

/**
 * Created by Alexandr on 11.06.2017.
 */
public interface MessageService {
    void save(Message message);
    List<Message> findMessagesByEvent(Event event);
    List<Message> findMessagesByStatusAndUser(User user);
    Message findMessageById(Long id);


}
