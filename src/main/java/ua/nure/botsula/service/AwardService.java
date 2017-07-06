package ua.nure.botsula.service;



import ua.nure.botsula.model.Award;

import java.util.List;

/**
 * Created by Alexandr on 14.06.2017.
 */
public interface AwardService {
    void save(Award award);
    List<Award> findAll();
    void delete(Award award);
}
