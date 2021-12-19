package nl.novi.fsdbe.controller;

import nl.novi.fsdbe.model.Employee;
import nl.novi.fsdbe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @GetMapping(value = "/employees")
//    public ResponseEntity<Object> getEmployees() {
//        return ResponseEntity.ok(employeeService.getEmployee());
//    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }



    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/employees")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        Long newId = employeeService.addEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

//    @GetMapping(value = "/persons/{id}/books")
//    public ResponseEntity<Object> getPersonBooks(@PathVariable int id) {
//        return ResponseEntity.ok(personService.getPersonBooks(id));
//    }
//
//    @PostMapping(value = "/persons/{id}/books")
//    public ResponseEntity<Object> addPersonBook(@PathVariable int id, @RequestBody Book book) {
//        personService.addPersonBook(id, book);
//        return ResponseEntity.created(null).build();
//    }
//}

}
