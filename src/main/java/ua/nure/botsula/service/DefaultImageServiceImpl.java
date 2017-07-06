package ua.nure.botsula.service;


import org.springframework.stereotype.Service;
import ua.nure.botsula.dao.DefaultImageDao;
import ua.nure.botsula.model.DefaultImage;

/**
 * Created by Alexandr on 02.06.2017.
 */
@Service
public class DefaultImageServiceImpl implements DefaultImageService {
    private DefaultImageDao defaultImageDao;
    @Override
    public DefaultImage findImageById(Long id) {
        DefaultImage defaultImage = defaultImageDao.findImageById(id);
        return defaultImage;
    }
}
