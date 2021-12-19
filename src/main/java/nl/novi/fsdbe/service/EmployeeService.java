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

    public Iterable<Employee> getPersons(String title) {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }
        else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }

    }

    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public Long addEmployee(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee.getId();
    }

//    public List<Book> getPersonBooks(int id) {
//        Optional<Person> optionalPerson = personRepository.findById(id);
//
//        if (optionalPerson.isPresent()) {
//            Person person = optionalPerson.get();
//            return person.getBooks();
//        }
//        else {
//            throw new RecordNotFoundException("ID does not exist!!!");
//        }
//    }

//    public void addPersonBook(int id, Book book) {
//        Optional<Person> optionalPerson = personRepository.findById(id);
//
//        if (optionalPerson.isPresent()) {
//            Person person = optionalPerson.get();
//            List<Book> books = person.getBooks();
//
//            bookRepository.save(book);
//
//            books.add(book);
//            personRepository.save(person);
//        }
//        else {
//            throw new RecordNotFoundException("ID does not exist!!!");
//        }
//    }


}
