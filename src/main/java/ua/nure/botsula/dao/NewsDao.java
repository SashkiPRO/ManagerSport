package ua.nure.botsula.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.botsula.model.News;

/**
 * Created by Alexandr on 06.06.2017.
 */
public interface NewsDao extends JpaRepository<News, Long>{
}
