package nl.novi.fsdbe.controller;


import nl.novi.fsdbe.model.Medicine;
import nl.novi.fsdbe.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getMedicines() {
        return ResponseEntity.ok(medicineService.getMedicines());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getMedicine(@PathVariable Long id) {
        return ResponseEntity.ok(medicineService.getMedicine(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteMedicine(@PathVariable("id") Long id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> addMedicine(@RequestBody Medicine medicine) {
        Long newId = medicineService.addMedicine(medicine);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicine) {
        medicineService.updateMedicine(id, medicine);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> partialUpdateMedicine(@PathVariable Long id, @RequestBody Medicine medicine) {
        medicineService.partialUpdateMedicine(id, medicine);

        return ResponseEntity.noContent().build();
    }

}
