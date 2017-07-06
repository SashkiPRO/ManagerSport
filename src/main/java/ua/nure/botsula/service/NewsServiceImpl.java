package ua.nure.botsula.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.botsula.dao.NewsDao;
import ua.nure.botsula.model.News;

import java.util.List;

/**
 * Created by Alexandr on 06.06.2017.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public void save(News news) {
        newsDao.save(news);
    }

    @Override
    public void remove(Long id) {
        newsDao.delete(id);
    }

    @Override
    public List<News> findAll() {
        return newsDao.findAll();
    }
}
