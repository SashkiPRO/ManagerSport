package util;

import net.proselyte.springsecurityapp.model.Tour;
import net.proselyte.springsecurityapp.model.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/**
 * Created by Alexandr on 09.05.2017.
 */
@Component
public class TourPropertyEditor extends PropertyEditorSupport {
    @Autowired
    private TourService tourService;
    @Override
    public void setAsText(String id){
        Tour tour = tourService.findTourById(Long.parseLong(id));
        this.setValue(tour);
        return;
    }
}
