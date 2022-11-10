package de.awacademy.web.db2.service;

import de.awacademy.web.db2.model.Employee;
import de.awacademy.web.db2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(); // SELECT ALL || SELECT *
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee); // INSERT
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = this.employeeRepository.findById(id);
        Employee employee = null;

        if(optional.isPresent()){
            employee = optional.get();
        }else {
            throw new RuntimeException("Employee with id " + id + " was not found");
        }

        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }
}
