package de.awacademy.web.db2.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    @Id // primary key (can't be null and has to be unique
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "First name can't be empty!")
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty(message = "Last name can't be empty!")
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    @Email(message = "Email pattern it's not correct!")
    @NotEmpty(message = "Email can't be empty")
    @Column(name = "email")
    private String email;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @ManyToOne(optional = false)
    @JoinColumn(name ="department_id", nullable = false)
    private Department department;


    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")}
    )
    Set<Project> projects = new HashSet<>();


//  Default Constructor
    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
