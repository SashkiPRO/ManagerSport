package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.dao.AwardDao;
import net.proselyte.springsecurityapp.model.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 14.06.2017.
 */
@Service
public class AwardServiceImpl implements AwardService{
    @Autowired
    private AwardDao awardDao;

    @Override
    public void save(Award award) {
        awardDao.save(award);
    }

    @Override
    public List<Award> findAll() {
        return awardDao.findAll();
    }

    @Override
    public void delete(Award award) {
awardDao.delete(award);
    }
}
