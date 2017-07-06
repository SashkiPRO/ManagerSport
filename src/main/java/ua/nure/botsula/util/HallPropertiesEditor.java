package ua.nure.botsula.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.botsula.model.Hall;
import ua.nure.botsula.service.HallService;

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
