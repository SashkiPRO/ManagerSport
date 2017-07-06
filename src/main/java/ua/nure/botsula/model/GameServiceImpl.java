package ua.nure.botsula.model;

import net.proselyte.springsecurityapp.dao.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 01.05.2017.
 */
@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameDao gameDao;
    @Override
    public List<Game> findAll() {
        return gameDao.findAll();
    }

    @Override
    public void save(Game game) {
        gameDao.save(game);
    }

    @Override
    public List<Game> findGamesByTournamentId(Long id) {
        return gameDao.findGamesByTournamentId(id);
    }

    @Override
    public Game findGameById(Long id) {
        return gameDao.findGameById(id);
    }
}
