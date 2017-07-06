package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.model.Award;

import java.util.List;

/**
 * Created by Alexandr on 15.06.2017.
 */
public interface AwardService {
    void save(Award award);
    List<Award> findAll();
    void delete(Award award);

}
