package ua.nure.botsula.service;



import ua.nure.botsula.model.Penalty;

import java.util.List;

/**
 * Created by Alexandr on 14.06.2017.
 */
public interface PenaltyService {
    void save(Penalty penalty);
    List<Penalty> findAll();
    void delete(Penalty penalty);
}
