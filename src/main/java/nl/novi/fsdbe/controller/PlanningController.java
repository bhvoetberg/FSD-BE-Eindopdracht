package nl.novi.fsdbe.controller;

import nl.novi.fsdbe.model.Employee;
import nl.novi.fsdbe.model.Planning;
import nl.novi.fsdbe.service.PlanningService;
import org.hibernate.boot.model.source.spi.PluralAttributeNature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/planning")
public class PlanningController {

    @Autowired
    private PlanningService planningService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getPlanning() {
        return ResponseEntity.ok(planningService.getPlanning());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getPlanning(@PathVariable Long id) {
        return ResponseEntity.ok(planningService.getPlanning(id));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id) {
        planningService.deletePlanning(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> addPlanning(@RequestBody Planning planning) {
        Long newId = planningService.addPlanning(planning);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updatePlanning(@PathVariable Long id, @RequestBody Planning planning) {
        planningService.updatePlanning(id, planning);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> partialUpdatePlanning(@PathVariable Long id, @RequestBody Planning planning) {
        planningService.partialUpdatePlanning(id, planning);

        return ResponseEntity.noContent().build();
    }

}
