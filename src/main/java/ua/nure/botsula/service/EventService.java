package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.model.Event;

import java.util.List;

/**
 * Created by Alexandr on 11.06.2017.
 */
public interface EventService {
    void save(Event event);
    List<Event> findAll();
    Event findEventById(Long id);
    List<Event> findAllByOrderByDate();
}
