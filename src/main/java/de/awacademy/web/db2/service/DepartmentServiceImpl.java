package de.awacademy.web.db2.service;

import de.awacademy.web.db2.model.Department;
import de.awacademy.web.db2.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(long id) {
        Optional<Department> optional = this.departmentRepository.findById(id);
        Department department = null;

        if(optional.isPresent()){
            department = optional.get();
        }else {
            throw new RuntimeException("Department with id " + id + " was not found");
        }

        return department;
    }

    @Override
    public void deleteDepartmentById(long id) {
        this.departmentRepository.deleteById(id);
    }
}
