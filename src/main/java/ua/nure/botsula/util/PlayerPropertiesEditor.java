package ua.nure.botsula.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.botsula.model.Player;
import ua.nure.botsula.service.PlayerService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Alexandr on 31.05.2017.
 */
@Component
public class PlayerPropertiesEditor extends PropertyEditorSupport {
@Autowired
private PlayerService playerService;
    @Override
    public void setAsText(String id){
        Player player = playerService.findPlayerById(Long.parseLong(id));

        setValue(player);
    }
    @Override
    public String getAsText(){
        Player player =(Player)this.getValue();
        return player.getId().toString();
    }
}
