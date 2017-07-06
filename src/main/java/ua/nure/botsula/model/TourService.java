package ua.nure.botsula.model;

import java.util.List;

/**
 * Created by Alexandr on 01.05.2017.
 */
public interface TourService {
    List<Tour> findAll();
    void save(Tour tour);
    Tour findTourByName(String name);
    Tour findTourById(Long id);
    void delete(List<Tour> tourList);
}
