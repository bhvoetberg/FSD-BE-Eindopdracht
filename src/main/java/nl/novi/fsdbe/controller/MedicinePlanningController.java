package nl.novi.fsdbe.controller;

import nl.novi.fsdbe.model.Planning;
import nl.novi.fsdbe.service.MedicinePlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicine")
public class MedicinePlanningController {

    @Autowired
    MedicinePlanningService medicinePlanningService;

    @PostMapping(value = "/{id}/planning")
    public ResponseEntity<Object> addMedicinePlanning(@PathVariable Long id,
                                                      @RequestBody Planning planning) {
        medicinePlanningService.addMedicinePlanning(id, planning);
        return ResponseEntity.ok().body(planning.getId());
    }

}
