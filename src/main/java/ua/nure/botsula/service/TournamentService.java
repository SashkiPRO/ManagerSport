package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.model.Tournament;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Alexandr on 30.04.2017.
 */
public interface TournamentService {
    List<Tournament> findAll();
    void save(@Valid Tournament tournament);
    Tournament findTournamentById(Long id);
    void remove(Tournament tournament);
}
