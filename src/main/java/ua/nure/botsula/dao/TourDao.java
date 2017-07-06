package ua.nure.botsula.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.botsula.model.Tour;

/**
 * Created by Alexandr on 01.05.2017.
 */
public interface TourDao extends JpaRepository<Tour, Long> {
    Tour findTourByName(String name);
    Tour findTourById(Long id);
}
