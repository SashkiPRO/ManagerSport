package ua.nure.botsula.service;



import ua.nure.botsula.model.Team;

import java.util.List;

/**
 * Created by Alexandr on 30.04.2017.
 */
public interface TeamService {
    List<Team> findAll();
    void save(Team team);
    Team findTeamById(Long id);
}
