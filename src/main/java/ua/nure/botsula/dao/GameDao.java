package ua.nure.botsula.dao;

import net.proselyte.springsecurityapp.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Alexandr on 01.05.2017.
 */
public interface GameDao extends JpaRepository<Game, Long>{
    List<Game> findGamesByTournamentId(Long id);
    Game findGameById(Long id);
}
