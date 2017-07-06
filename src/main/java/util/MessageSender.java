package util;

import net.proselyte.springsecurityapp.model.Event;
import net.proselyte.springsecurityapp.model.User;
import net.proselyte.springsecurityapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by Alexandr on 11.06.2017.
 */
public class MessageSender {
    @Autowired
    private MessageService messageService;
    public MessageSender() {
    }
    public void sendMessages(Set<User> users, Event event){



    }
}
