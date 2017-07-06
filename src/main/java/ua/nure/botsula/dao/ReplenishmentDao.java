package ua.nure.botsula.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.botsula.model.Replenishment;

/**
 * Created by Alexandr on 14.06.2017.
 */
public interface ReplenishmentDao extends JpaRepository<Replenishment, Long> {
}
