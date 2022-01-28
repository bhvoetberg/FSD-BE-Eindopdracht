package nl.novi.fsdbe.repository;

import nl.novi.fsdbe.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
