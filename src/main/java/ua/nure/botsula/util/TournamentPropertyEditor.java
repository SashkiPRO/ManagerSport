package ua.nure.botsula.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.botsula.model.Tournament;
import ua.nure.botsula.service.TournamentService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Alexandr on 15.05.2017.
 */
@Component
public class TournamentPropertyEditor extends PropertyEditorSupport {
    @Autowired
    private TournamentService tournamentService;
    @Override
    public void setAsText(String id){
        Tournament tournament = tournamentService.findTournamentById(Long.parseLong(id));
        this.setValue(tournament);
        return;
    }
}
