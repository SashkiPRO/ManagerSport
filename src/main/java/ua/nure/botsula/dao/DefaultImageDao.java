package ua.nure.botsula.dao;

import net.proselyte.springsecurityapp.model.DefaultImage;

/**
 * Created by Alexandr on 02.06.2017.
 */
public interface DefaultImageDao {
    DefaultImage findImageById(Long id);
}
