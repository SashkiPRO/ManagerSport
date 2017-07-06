package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.dao.PenaltyDao;
import net.proselyte.springsecurityapp.model.Penalty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 14.06.2017.
 */
@Service
public class PenaltyServiceImpl implements PenaltyService{
@Autowired
private PenaltyDao penaltyDao;

    @Override
    public void save(Penalty penalty) {
        penaltyDao.save(penalty);
    }

    @Override
    public List<Penalty> findAll() {
        return penaltyDao.findAll();
    }

    @Override
    public void delete(Penalty penalty) {
    penaltyDao.delete(penalty);
    }
}
