package com.example.Assignment4.service;
import com.example.Assignment4.entity.Employee;
import com.example.Assignment4.entity.EmployeeType;
import java.util.List;

public interface SalaryCalculatorServiceInterface {
    List<Employee> findAll();
    List<Employee> getByType(EmployeeType employeeType);
    Employee findById(long id);
    void changeSalary(long id, double salary);
    void changeHourRate(long id, double rate);
    void changeCommRate(long id, float rate);
}
