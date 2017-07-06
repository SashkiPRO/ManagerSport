package ua.nure.botsula.util;

import net.proselyte.springsecurityapp.model.Hall;
import net.proselyte.springsecurityapp.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/**
 * Created by Alexandr on 09.05.2017.
 */
@Component
public class HallPropertiesEditor extends PropertyEditorSupport {
    @Autowired
    private HallService hallService;
    @Override
    public void setAsText(String id){
        Hall hall = hallService.findHallById(Long.parseLong(id));
        this.setValue(hall);
        return;
    }
}
