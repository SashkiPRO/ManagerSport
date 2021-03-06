package ua.nure.botsula.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.nure.botsula.model.Event;
import ua.nure.botsula.model.Message;
import ua.nure.botsula.model.User;

import java.util.List;

/**
 * Created by Alexandr on 11.06.2017.
 */
public interface MessageDao extends JpaRepository<Message, Long> {
    List<Message> findMessagesByEvent(Event event);
    List<Message> findMessagesByStatusAndUser(String status, User user);
    @Query("SELECT m FROM Message m WHERE m.status not like 'unread' and m.user =:user")
    public List<Message> find(@Param("user") User user);
    Message findMessageById(Long id);
}
