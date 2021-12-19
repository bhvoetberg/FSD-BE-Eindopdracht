package nl.novi.fsdbe.controller;

import nl.novi.fsdbe.model.Employee;
import nl.novi.fsdbe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getEmployees() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        Long newId = employeeService.addEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> partialUpdateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeService.partialUpdateEmployee(id, employee);

        return ResponseEntity.noContent().build();
    }

}
