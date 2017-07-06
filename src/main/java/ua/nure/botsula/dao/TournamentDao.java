package ua.nure.botsula.dao;

import net.proselyte.springsecurityapp.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alexandr on 30.04.2017.
 */
public interface TournamentDao extends JpaRepository< Tournament, Long> {
    Tournament findTournamentById(Long id);
}
