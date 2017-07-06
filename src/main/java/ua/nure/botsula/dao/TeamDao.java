package ua.nure.botsula.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.botsula.model.Team;

/**
 * Created by Alexandr on 30.04.2017.
 */
public interface TeamDao extends JpaRepository<Team, Long> {
    Team findTeamById(Long id);
}
