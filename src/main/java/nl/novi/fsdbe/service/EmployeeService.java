package nl.novi.fsdbe.service;

import nl.novi.fsdbe.exception.RecordNotFoundException;
import nl.novi.fsdbe.model.Employee;
import nl.novi.fsdbe.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }

    }

    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public Long addEmployee(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee.getId();
    }

    public void updateEmployee(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee storedEmployee = optionalEmployee.get();

            employee.setId(storedEmployee.getId());
            employeeRepository.save(employee);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

    public void partialUpdateEmployee(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee storedEmployee = employeeRepository.findById(id).orElse(null);

            if (employee.getFirstName() != null && !employee.getFirstName().isEmpty()) {
                storedEmployee.setFirstName(employee.getFirstName());
            }
            if (employee.getLastName() != null && !employee.getLastName().isEmpty()) {
                storedEmployee.setLastName(employee.getLastName());
            }
            if (employee.getFunctionName() != null && !employee.getFunctionName().isEmpty()) {
                storedEmployee.setFunctionName(employee.getFunctionName());
            }
            employeeRepository.save(storedEmployee);
        } else {
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

}
