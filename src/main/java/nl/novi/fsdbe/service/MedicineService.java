package nl.novi.fsdbe.service;

import nl.novi.fsdbe.exception.RecordNotFoundException;
import nl.novi.fsdbe.model.Medicine;
import nl.novi.fsdbe.repository.EmployeeRepository;
import nl.novi.fsdbe.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public Iterable<Medicine> getMedicines() {
        return medicineRepository.findAll();
    }

    public Medicine getMedicine(Long id) {
        Optional<Medicine> optionalMedicine = medicineRepository.findById(id);
        if (optionalMedicine.isPresent()) {
            return optionalMedicine.get();
        } else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public void deleteMedicine(Long id) {
        if (medicineRepository.existsById(id)) {
            medicineRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public Long addMedicine(Medicine medicine) {
        Medicine newMedicine = medicineRepository.save(medicine);
        return newMedicine.getId();
    }

//    public void updateEmployee(Long id, Employee employee) {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//
//        if (optionalEmployee.isPresent()) {
//            Employee storedEmployee = optionalEmployee.get();
//
//            employee.setId(storedEmployee.getId());
//            employeeRepository.save(employee);
//        }
//        else {
//            throw new RecordNotFoundException("ID does not exist!");
//        }
//    }
//
//    public void partialUpdateEmployee(Long id, Employee employee) {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//
//        if (optionalEmployee.isPresent()) {
//            Employee storedEmployee = employeeRepository.findById(id).orElse(null);
//
//            if (employee.getFirstName() != null && !employee.getFirstName().isEmpty()) {
//                storedEmployee.setFirstName(employee.getFirstName());
//            }
//            if (employee.getLastName() != null && !employee.getLastName().isEmpty()) {
//                storedEmployee.setLastName(employee.getLastName());
//            }
//            if (employee.getFunctionName() != null && !employee.getFunctionName().isEmpty()) {
//                storedEmployee.setFunctionName(employee.getFunctionName());
//            }
//            employeeRepository.save(storedEmployee);
//        } else {
//            throw new RecordNotFoundException("ID does not exist!");
//        }
//    }

}
