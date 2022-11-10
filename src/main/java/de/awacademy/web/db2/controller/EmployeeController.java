package de.awacademy.web.db2.controller;

import de.awacademy.web.db2.model.Department;
import de.awacademy.web.db2.model.Employee;
import de.awacademy.web.db2.service.DepartmentService;
import de.awacademy.web.db2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class EmployeeController {
//    @Autowired
//    private EmployeeService employeeService; //Invoking the interface
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }



    @GetMapping("/employees")
    public String employeeHome(Model model){
        model.addAttribute("listOfEmployees", employeeService.getAllEmployees());


        return "employees/index";
    }

    @GetMapping("/employees/showNewEmployeeForm")
    public String showNewEmployeeForm (Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("listOfDepartments", departmentService.getAllDepartments());

        return "employees/new";
    }

//    @PostMapping("/employees/saveEmployee")
//    public String saveEmployee(@ModelAttribute Employee employee){
//        employeeService.saveEmployee(employee);
//
//        return "redirect:/employees";
//    }

    @PostMapping("/employees/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute Employee employee,
                               BindingResult result,
                               @RequestParam(required = false) boolean activeEmpChk){
        if(result.hasErrors()){
            return "employees/new";
        }

//        if(activeEmpChk){
//            employee.setActive(true);
//        }else{
//            employee.setActive(false);
//        }
        //Pojednostavljeno
        employee.setActive(activeEmpChk);

        employeeService.saveEmployee(employee);

        return "redirect:/employees";
    }

///////////////////////////////////////////////////////////////////
//  Update
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("listOfDepartments", departmentService.getAllDepartments());

        return "employees/update";
    }
    @GetMapping("/showFormForDelete/{id}")
    public String showFormForDelete(@PathVariable(value = "id") long id){
        employeeService.deleteEmployeeById(id);

        return "redirect:/employees";
    }

}
