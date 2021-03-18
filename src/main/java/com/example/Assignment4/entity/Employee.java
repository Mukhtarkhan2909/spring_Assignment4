package com.example.Assignment4.entity;
import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double fixedsalary;
    private double hourrate;
    private int hoursworked;
    private float commrate;
    @Enumerated(EnumType.STRING)
    private EmployeeType employeetype;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getFixedSalary() {
        return fixedsalary;
    }
    public void setFixedSalary(double fixedsalary) {
        this.fixedsalary = fixedsalary;
    }
    public double getHourRate() {
        return hourrate;
    }
    public void setHourRate(double hourrate) {
        this.hourrate = hourrate;
    }
    public int getHoursWorked() {
        return hoursworked;
    }
    public void setHoursWorked(int hoursworked) {
        this.hoursworked = hoursworked;
    }
    public float getCommRate() {
        return commrate;
    }
    public void setCommRate(float commrate) {
        this.commrate = commrate;
    }
    public EmployeeType getEmployeeType() {
        return employeetype;
    }
    public void setEmployeeType(EmployeeType employeetype) {
        this.employeetype = employeetype;
    }

}
