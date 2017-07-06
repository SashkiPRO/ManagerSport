package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.model.Hall;

import java.util.List;

/**
 * Created by Alexandr on 30.04.2017.
 */

public interface HallService  {
    List<Hall> findAll();
    Hall findHallById(Long id);
    void save(Hall hall);
}
