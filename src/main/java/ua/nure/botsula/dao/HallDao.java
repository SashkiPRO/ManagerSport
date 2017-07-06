package ua.nure.botsula.dao;

import net.proselyte.springsecurityapp.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alexandr on 30.04.2017.
 */
public interface HallDao extends JpaRepository<Hall, Long> {
    Hall findHallById(Long id);
}
