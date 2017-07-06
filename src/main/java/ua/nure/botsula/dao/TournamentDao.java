package ua.nure.botsula.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.botsula.model.Tournament;

/**
 * Created by Alexandr on 30.04.2017.
 */
public interface TournamentDao extends JpaRepository<Tournament, Long> {
    Tournament findTournamentById(Long id);
}
