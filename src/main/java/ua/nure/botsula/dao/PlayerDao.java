package ua.nure.botsula.dao;

import net.proselyte.springsecurityapp.model.Player;
import net.proselyte.springsecurityapp.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Alexandr on 30.04.2017.
 */
public interface PlayerDao extends JpaRepository<Player, Long> {
    Player findPlayerById(Long id);
    List<Player> findPlayerByTeam(Team team);

}
