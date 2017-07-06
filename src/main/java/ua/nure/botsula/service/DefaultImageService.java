package ua.nure.botsula.service;


import ua.nure.botsula.model.DefaultImage;

/**
 * Created by Alexandr on 02.06.2017.
 */
public interface DefaultImageService {
    DefaultImage findImageById(Long id);
}
