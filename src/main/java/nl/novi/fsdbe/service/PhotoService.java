package nl.novi.fsdbe.service;

import nl.novi.fsdbe.model.Photo;
import nl.novi.fsdbe.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public Iterable<Photo> getPhotos() {
        return photoRepository.findAll();
    }

    public Long addPhoto(Photo photo) {
        Photo newPhoto = photoRepository.save(photo);
        return newPhoto.getId();
    }



}