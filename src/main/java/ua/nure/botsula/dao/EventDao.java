package ua.nure.botsula.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.botsula.model.Event;

import java.util.List;

/**
 * Created by Alexandr on 11.06.2017.
 */
public interface EventDao extends JpaRepository<Event, Long>{
    Event findEventById(Long id);
    List<Event> findAllByOrderByDateAsc();
}
