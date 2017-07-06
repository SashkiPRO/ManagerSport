package ua.nure.botsula.service;



import ua.nure.botsula.model.Replenishment;

import java.util.List;

/**
 * Created by Alexandr on 14.06.2017.
 */
public interface ReplenishmentService {
    void save(Replenishment replenishment);
    List<Replenishment> findAll();
}
