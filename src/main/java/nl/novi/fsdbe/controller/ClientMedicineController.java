package nl.novi.fsdbe.controller;

import nl.novi.fsdbe.model.Medicine;
import nl.novi.fsdbe.model.Planning;
import nl.novi.fsdbe.service.ClientMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientMedicineController {

    @Autowired
    ClientMedicineService clientMedicineService;

    @PostMapping(value = "/{clientId}/{medicineId}")
    public ResponseEntity<Object> addMedicinePlanning(@PathVariable Long clientId,
                                                      @PathVariable Long medicineId) {
        clientMedicineService.addClientMedicine(clientId, medicineId);
        return ResponseEntity.created(null).build();
    }
}
