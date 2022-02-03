package nl.novi.fsdbe.controller;

import nl.novi.fsdbe.model.Client;
import nl.novi.fsdbe.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getClients() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClient(id));
    }

//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Object> deleteClient(@PathVariable("id") Long id) {
//        clientService.deleteClient(id);
//        return ResponseEntity.noContent().build();
//    }

    @DeleteMapping(value = "/{id}/photo")
    public ResponseEntity<Object> deleteClientPhoto(@PathVariable("id") Long id) {
        clientService.deleteClientPhoto(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> addClient(@RequestBody Client client) {
        Long newId = clientService.addClient(client);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable Long id, @RequestBody Client client) {
        clientService.updateClient(id, client);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> partialUpdateClient(@PathVariable Long id, @RequestBody Client client) {
        clientService.partialUpdateClient(id, client);

        return ResponseEntity.noContent().build();
    }



}
