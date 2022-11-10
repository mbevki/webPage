package de.awacademy.web.db2.service;

import de.awacademy.web.db2.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    void saveDepartment(Department department);
    Department getDepartmentById(long id);
    void deleteDepartmentById(long id);

//    List<Employee> getAllEmployeeByDepartmentId(long id);

}
