package nl.novi.fsdbe.controller;

import nl.novi.fsdbe.model.Deviation;
import nl.novi.fsdbe.model.Employee;
import nl.novi.fsdbe.service.DeviationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/deviations")
public class DeviationController {

    @Autowired
    private DeviationService deviationService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getDeviations() {
        return ResponseEntity.ok(deviationService.getDeviations());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getDeviation(@PathVariable Long id) {
        return ResponseEntity.ok(deviationService.getDeviation(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteDeviation(@PathVariable("id") Long id) {
        deviationService.deleteDeviation(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> addDeviation(@RequestBody Deviation deviation) {
        Long newId = deviationService.addDeviation(deviation);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateDeviation (@PathVariable Long id, @RequestBody Deviation deviation) {
        deviationService.updateDeviation(id, deviation);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> partialUpdateDeviation (@PathVariable Long id, @RequestBody Deviation deviation) {
        deviationService.partialUpdateDeviation(id, deviation);
        return ResponseEntity.noContent().build();
    }


}
