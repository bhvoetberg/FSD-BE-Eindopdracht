package nl.novi.fsdbe.service;

import nl.novi.fsdbe.model.Employee;

import nl.novi.fsdbe.repository.EmployeeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee1;
    private Employee employee2;
    List<Employee> employeeList = new ArrayList<>();

    @BeforeEach
    public void setup(){
        this.employee1 = new Employee();
        this.employee2 = new Employee();
        this.employeeList = new ArrayList<>();

        employee1.setFirstName("Bert");
        employee1.setId(123L);
        employee2.setId(124L);
        employee2.setFirstName("Ernie");
        employeeList.add(employee1);
        employeeList.add(employee2);
    }

    @Test
    @DisplayName("Should return 2 employees of which the first with firstname 'Bert'")
    public void getEmployees() {

        when(employeeRepository.findAll()).thenReturn(employeeList);

        employeeService.getEmployees();

        verify(employeeRepository,times(1)).findAll();
        assertThat(employeeList.size()).isEqualTo(2);
        assertThat(employeeList.get(0).getFirstName()).isEqualTo("Bert");
    }

    @Test
    @DisplayName("Should save employee1")
    public void givenEmployeeObject_whenSaveEmployee_thenReturnIsNotNull() {

        given(employeeRepository.save(employee1)).willReturn(employee1);

        Long savedEmployee = employeeService.addEmployee(employee1);

        assertThat(savedEmployee).isNotNull();
    }

    @Test
    @DisplayName("Should return employee2 by ID")
    public void givenEmployee2Id_thenReturnEmployee2Object() {
        given(employeeRepository.findById(employee2.getId())).willReturn(Optional.of(employee2));

        Employee saveEmployee2 = employeeService.getEmployee(employee2.getId());

        assertThat(saveEmployee2).isNotNull();
    }

}