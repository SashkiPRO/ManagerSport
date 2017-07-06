package ua.nure.botsula.service;


import ua.nure.botsula.model.Player;
import ua.nure.botsula.model.Team;

import java.util.List;

/**
 * Created by Alexandr on 30.04.2017.
 */
public interface PlayerService {
    List<Player> findAll();
    void save(Player player);
    Player findPlayerById(Long id);
    List<Player> findPlayersByTeam(Team team);
}
