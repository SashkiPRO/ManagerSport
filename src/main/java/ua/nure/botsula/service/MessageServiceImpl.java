package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.dao.MessageDao;
import net.proselyte.springsecurityapp.model.Event;
import net.proselyte.springsecurityapp.model.Message;
import net.proselyte.springsecurityapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 11.06.2017.
 */
@Service
public class MessageServiceImpl implements MessageService {
   private static final String UNREAD_MESSAGE_STATUS="unread";
    @Autowired
    private MessageDao messageDao;
    @Override
    public void save(Message message) {
        messageDao.save(message);
    }

    @Override
    public List<Message> findMessagesByEvent(Event event) {
        return messageDao.findMessagesByEvent(event);
    }

    @Override
    public List<Message> findMessagesByStatusAndUser( User user) {
        return messageDao.findMessagesByStatusAndUser(UNREAD_MESSAGE_STATUS,user);
    }

    @Override
    public Message findMessageById(Long id) {
        return messageDao.findMessageById(id);
    }


}
