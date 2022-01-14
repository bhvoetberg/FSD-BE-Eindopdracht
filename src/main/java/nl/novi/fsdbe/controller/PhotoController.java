package nl.novi.fsdbe.controller;

import nl.novi.fsdbe.model.Photo;
import nl.novi.fsdbe.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping
    public ResponseEntity<Object> getPhotos() {
        return ResponseEntity.ok(photoService.getPhotos());
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> addPhoto(@RequestBody Photo photo) {
        Long newId = photoService.addPhoto(photo);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

//    @GetMapping("id")
//    public ResponseEntity<Object> getFileInfo(@PathVariable long id) {
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("id/file")
//    public ResponseEntity<Object> getFileData(@PathVariable long id) {
//        return ResponseEntity.noContent().build();
//    }

//    @DeleteMapping
//    public ResponseEntity<Object> deleteFile() {
//        return ResponseEntity.noContent().build();
//    }

}
