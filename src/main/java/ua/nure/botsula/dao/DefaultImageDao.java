package ua.nure.botsula.dao;


import ua.nure.botsula.model.DefaultImage;

/**
 * Created by Alexandr on 02.06.2017.
 */
public interface DefaultImageDao {
    DefaultImage findImageById(Long id);
}
