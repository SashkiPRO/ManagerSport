package ua.nure.botsula.util;

import net.proselyte.springsecurityapp.model.Message;
import net.proselyte.springsecurityapp.model.User;
import net.proselyte.springsecurityapp.service.MessageService;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Alexandr on 11.06.2017.
 */
@Component
public class MessageScheduler {
    @Autowired
    private MessageService messageService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    UserService userService;
    public void setMessages() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User auth = userService.findByLogin(name);
        HttpSession session = request.getSession(true);
        List<Message> messages = messageService.findMessagesByStatusAndUser(auth);
        for(Message m:messages){
            System.out.print(m);
        }
        session.setAttribute("messages", messages);

    }
}
