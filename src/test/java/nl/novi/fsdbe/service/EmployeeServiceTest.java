package nl.novi.fsdbe.service;

import nl.novi.fsdbe.model.Client;
import nl.novi.fsdbe.model.Employee;

import nl.novi.fsdbe.repository.EmployeeRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    @DisplayName("Should return 2 employees of which the first with firstname 'Bert'")
    void getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.setFirstName("Bert");
        employee2.setFirstName("Ernie");
        employeeList.add(employee1);
        employeeList.add(employee2);

        when(employeeRepository.findAll()).thenReturn(employeeList);

        employeeService.getEmployees();

        verify(employeeRepository,times(1)).findAll();
        assertThat(employeeList.size()).isEqualTo(2);
        assertThat(employeeList.get(0).getFirstName()).isEqualTo("Bert");
    }

    @Test
    @DisplayName("Should find employee with ID 2")
    void getEmployee() {


//        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);
//
//        verify(clientRepository).save(clientArgumentCaptor.capture());
//
//        when(clientRepository.findAll()).thenReturn(clientList);
//
//        Client capturedClient = clientArgumentCaptor.getValue();
//
//        AssertionsForClassTypes.assertThat(capturedClient).isEqualTo(client1);
//
        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.setFirstName("Bert");
        employee2.setFirstName("Ernie");
        employeeList.add(employee1);
        employeeList.add(employee2);

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee1));

        employeeService.getEmployee(1L);

        assertThat(employee1.getId()).isEqualTo(1L);
    }

    @Test
    @Disabled
    void deleteEmployee() {
    }

    @Test
    @Disabled
    void addEmployee() {
    }

    @Test
    @Disabled
    void updateEmployee() {
    }

    @Test
    @Disabled
    void partialUpdateEmployee() {
    }
}