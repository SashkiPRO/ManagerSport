package ua.nure.botsula.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.botsula.dao.MessageDao;
import ua.nure.botsula.model.Event;
import ua.nure.botsula.model.Message;
import ua.nure.botsula.model.User;

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
