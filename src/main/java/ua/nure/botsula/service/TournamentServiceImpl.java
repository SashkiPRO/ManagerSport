package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.dao.TournamentDao;
import net.proselyte.springsecurityapp.model.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 30.04.2017.
 */
@Service
public class TournamentServiceImpl implements TournamentService{
    @Autowired
  private   TournamentDao tournamentDao;

    @Override
    public List<Tournament> findAll() {
        return tournamentDao.findAll();
    }

    @Override
    public void save(Tournament tournament) {
        tournamentDao.save(tournament);
    }

    @Override
    public Tournament findTournamentById(Long id) {
        return tournamentDao.findTournamentById(id);
    }

    @Override
    public void remove(Tournament tournament) {
        tournamentDao.delete(tournament);
    }
}
