package nl.novi.fsdbe.service;

import nl.novi.fsdbe.exception.RecordNotFoundException;
import nl.novi.fsdbe.model.Client;
import nl.novi.fsdbe.model.Photo;
import nl.novi.fsdbe.repository.ClientRepository;
import nl.novi.fsdbe.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientPhotoService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PhotoRepository photoRepository;

    public void addClientPhoto(Long clientId, Photo photo) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            photo.setClient(client);
            photoRepository.save(photo);
            System.out.println(photo.getId());
            client.setPhoto(photo);
            clientRepository.save(client);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

//    public void updateClientPhoto(Long clientId, Long photoId, Photo photo) {
//        Optional<Client> optionalClient = clientRepository.findById(clientId);
//        Optional<Photo> optionalPhoto = photoRepository.findById(photoId);
//        if (optionalClient.isPresent() && optionalPhoto.isPresent()) {
//            Client client = optionalClient.get();
//            optionalPhoto
//            Photo photo = optionalPhoto.get();
//            client.setPhoto(photo);
//            photo.setClient(client);
//            photoRepository.save(photo);
//        }
//        else {
//            throw new RecordNotFoundException("ID does not exist!");
//        }
//    }

}
