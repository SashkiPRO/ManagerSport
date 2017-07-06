package ua.nure.botsula.dao;

import net.proselyte.springsecurityapp.model.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alexandr on 14.06.2017.
 */
public interface PenaltyDao extends JpaRepository<Penalty, Long> {

}
