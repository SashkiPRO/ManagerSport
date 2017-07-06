package ua.nure.botsula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.botsula.dao.PlayerDao;
import ua.nure.botsula.model.Player;
import ua.nure.botsula.model.Team;

import java.util.List;

/**
 * Created by Alexandr on 30.04.2017.
 */
@Service
public class PlayerServiceImpl implements PlayerService{
    @Autowired
    private PlayerDao playerDao;
    @Override
    public List<Player> findAll() {
        return playerDao.findAll();
    }

    @Override
    public void save(Player player) {
        playerDao.save(player);
    }

    @Override
    public Player findPlayerById(Long id) {
        return playerDao.findPlayerById(id);
    }

    @Override
    public List<Player> findPlayersByTeam(Team team) {
        return playerDao.findPlayerByTeam(team);
    }
}
