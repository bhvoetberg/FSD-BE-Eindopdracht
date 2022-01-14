package nl.novi.fsdbe.controller;

import nl.novi.fsdbe.model.Photo;
import nl.novi.fsdbe.model.Planning;
import nl.novi.fsdbe.service.ClientPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientphoto")
public class ClientPhotoController {

    @Autowired
    ClientPhotoService clientPhotoService;

    @PostMapping(value = "/{id}/photo")
    public ResponseEntity<Object> addClientPhoto(@PathVariable Long id,
                                                      @RequestBody Photo photo) {
        clientPhotoService.addClientPhoto(id, photo);
        return ResponseEntity.created(null).build();
    }

}
