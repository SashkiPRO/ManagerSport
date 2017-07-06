package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.dao.HallDao;
import net.proselyte.springsecurityapp.model.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 30.04.2017.
 */
@Service
public class HallServiceImpl implements HallService {
    @Autowired
    private HallDao hallDao;

    @Override
    public List<Hall> findAll() {
        return hallDao.findAll();
    }

    @Override
    public Hall findHallById(Long id) {
        return hallDao.findHallById(id);
    }

    @Override
    public void save(Hall hall) {
    hallDao.save(hall);
    }
}
