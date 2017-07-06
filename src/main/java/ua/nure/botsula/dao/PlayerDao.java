package ua.nure.botsula.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.botsula.model.Player;
import ua.nure.botsula.model.Team;

import java.util.List;

/**
 * Created by Alexandr on 30.04.2017.
 */
public interface PlayerDao extends JpaRepository<Player, Long> {
    Player findPlayerById(Long id);
    List<Player> findPlayerByTeam(Team team);

}
