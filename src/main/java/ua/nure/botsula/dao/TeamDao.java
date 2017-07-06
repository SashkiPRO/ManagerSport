package ua.nure.botsula.dao;

import net.proselyte.springsecurityapp.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alexandr on 30.04.2017.
 */
public interface TeamDao extends JpaRepository<Team, Long> {
    Team findTeamById(Long id);
}
