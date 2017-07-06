package ua.nure.botsula.service;



import ua.nure.botsula.model.News;

import java.util.List;

/**
 * Created by Alexandr on 06.06.2017.
 */
public interface NewsService {
    void save(News news);
    void remove(Long id);
    List<News> findAll();
}
