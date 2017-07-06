package ua.nure.botsula.service;



import ua.nure.botsula.model.Event;
import ua.nure.botsula.model.Message;
import ua.nure.botsula.model.User;

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
