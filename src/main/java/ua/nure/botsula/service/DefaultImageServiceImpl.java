package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.dao.DefaultImageDao;
import net.proselyte.springsecurityapp.model.DefaultImage;
import org.springframework.stereotype.Service;

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
