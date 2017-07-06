package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.dao.TeamDao;
import net.proselyte.springsecurityapp.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 30.04.2017.
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDao teamDao;

    @Override
    public List<Team> findAll() {
        return teamDao.findAll();
    }

    @Override
    public void save(Team team) {
        teamDao.save(team);
    }

    @Override
    public Team findTeamById(Long id) {
        return teamDao.findTeamById(id);
    }
}
