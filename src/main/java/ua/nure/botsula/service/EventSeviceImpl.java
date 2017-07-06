package ua.nure.botsula.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.botsula.dao.EventDao;
import ua.nure.botsula.model.Event;

import java.util.List;

/**
 * Created by Alexandr on 11.06.2017.
 */
@Service
public class EventSeviceImpl implements EventService {
    @Autowired
    private EventDao eventDao;
    @Override
    public void save(Event event) {
        eventDao.save(event);
    }

    @Override
    public List<Event> findAll() {
        return eventDao.findAll();
    }

    @Override
    public Event findEventById(Long id) {
        return eventDao.findEventById(id);
    }

    @Override
    public List<Event> findAllByOrderByDate() {
        return eventDao.findAllByOrderByDateAsc();
    }
}
