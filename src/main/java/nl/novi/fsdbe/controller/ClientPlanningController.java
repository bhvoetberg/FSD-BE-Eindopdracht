package nl.novi.fsdbe.controller;

import nl.novi.fsdbe.service.ClientPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientplanning")
public class ClientPlanningController {

    @Autowired
    ClientPlanningService clientPlanningService;

    @PostMapping(value = "/{clientId}/{planningId}")
    public ResponseEntity<Object> addMedicinePlanning(@PathVariable Long clientId,
                                                      @PathVariable Long planningId) {
        clientPlanningService.addClientPlanning(clientId, planningId);
        return ResponseEntity.created(null).build();
    }
}
