package ua.nure.botsula.model;

import net.proselyte.springsecurityapp.dao.TourDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 01.05.2017.
 */
@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourDao tourDao;

    @Override
    public List<Tour> findAll() {
        return tourDao.findAll();
    }

    @Override
    public void save(Tour tour) {
        tourDao.save(tour);
    }

    @Override
    public Tour findTourByName(String name) {
       return tourDao.findTourByName(name);
    }

    @Override
    public Tour findTourById(Long id) {
        return tourDao.findTourById(id);
    }

    @Override
    public void delete(List<Tour> tour) {
        tourDao.delete(tour);
    }
}
