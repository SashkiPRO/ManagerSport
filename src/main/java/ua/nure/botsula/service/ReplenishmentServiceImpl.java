package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.dao.ReplenishmentDao;
import net.proselyte.springsecurityapp.model.Replenishment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 14.06.2017.
 */
@Service
public class ReplenishmentServiceImpl implements ReplenishmentService {
    @Autowired
    private ReplenishmentDao replenishmentDao;

    @Override
    public void save(Replenishment replenishment) {
        replenishmentDao.save(replenishment);
    }

    @Override
    public List<Replenishment> findAll() {
        return replenishmentDao.findAll();
    }
}
