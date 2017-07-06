package ua.nure.botsula.dao;

import net.proselyte.springsecurityapp.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alexandr on 06.06.2017.
 */
public interface NewsDao extends JpaRepository<News, Long>{
}
