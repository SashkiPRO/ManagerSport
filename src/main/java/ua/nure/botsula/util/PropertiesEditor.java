package ua.nure.botsula.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.botsula.model.Team;
import ua.nure.botsula.service.TeamService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Alexandr on 08.05.2017.
 */
@Component
public class PropertiesEditor extends PropertyEditorSupport {
    @Autowired
    private TeamService teamService;

   @Override
    public void setAsText(String id){
    Team team = teamService.findTeamById(Long.parseLong(id));
       this.setValue(team);
            return;
    }
}
