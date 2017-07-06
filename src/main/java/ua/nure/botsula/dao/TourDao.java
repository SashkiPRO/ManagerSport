package ua.nure.botsula.dao;

import net.proselyte.springsecurityapp.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alexandr on 01.05.2017.
 */
public interface TourDao extends JpaRepository<Tour, Long> {
    Tour findTourByName(String name);
    Tour findTourById(Long id);
}
