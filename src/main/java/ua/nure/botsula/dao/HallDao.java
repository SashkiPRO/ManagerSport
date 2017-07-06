package ua.nure.botsula.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.botsula.model.Hall;

/**
 * Created by Alexandr on 30.04.2017.
 */
public interface HallDao extends JpaRepository<Hall, Long> {
    Hall findHallById(Long id);
}
