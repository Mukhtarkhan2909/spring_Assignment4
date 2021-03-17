package com.example.Assignment4.dao;

import com.example.Assignment4.entity.Employee;
import com.example.Assignment4.entity.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeesByEmployeetype(EmployeeType employeeType);
    Employee findEmployeesById(long id);
    List<Employee> findAll();

}
