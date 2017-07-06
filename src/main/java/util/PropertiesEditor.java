package util;

import net.proselyte.springsecurityapp.model.Team;
import net.proselyte.springsecurityapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
