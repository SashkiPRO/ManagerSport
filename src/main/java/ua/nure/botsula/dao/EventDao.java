package ua.nure.botsula.dao;

import net.proselyte.springsecurityapp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Alexandr on 11.06.2017.
 */
public interface EventDao extends JpaRepository<Event, Long>{
    Event findEventById(Long id);
    List<Event> findAllByOrderByDateAsc();
}
