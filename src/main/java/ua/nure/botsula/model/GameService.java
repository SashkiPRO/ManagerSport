package ua.nure.botsula.model;

import java.util.List;

/**
 * Created by Alexandr on 01.05.2017.
 */
public interface GameService {
    List<Game> findAll();
    void save(Game game);
    List<Game> findGamesByTournamentId(Long id);
    Game findGameById(Long id);
}
