package de.awacademy.web.db2.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "deparments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Department number could not be empty!")
    @Size(min = 1, max = 2, message = "Number should have between 1 and 2 digits...")
    @Column(name = "deptNum", unique = true, nullable = false, length = 2, precision = 0)
    private double number;

    @NotEmpty(message = "Department name could not be empty!")
    @Column(name = "deptName", nullable = false)
    private String name;

    @Column(name = "deptLoc", nullable = false)
    private String location;

    public Department() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
