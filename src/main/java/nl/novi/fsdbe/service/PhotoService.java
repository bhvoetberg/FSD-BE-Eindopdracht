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

//    public Iterable<Photo> getFiles() {
//        return repository.findAll();
//    }
//
//    public long uploadFile(MultipartFile file) {
//        Photo newFile = repository.save(file);
//        return newFile.id();
//    }
//
//    public void deleteFile(long id) {
//        if (!repository.existsById(id)) throw new RecordNotFoundException();
//        repository.deleteById(id);
//    }
//
//    public Optional<Photo> getFileById(long id) {
//        if (!repository.existsById(id)) throw new RecordNotFoundException();
//        return repository.findById(id);
//    }
//
//    public boolean fileExistsById(long id) {
//        return repository.existsById(id);
//    }

}