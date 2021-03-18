package com.example.Assignment4.service;
import com.example.Assignment4.repository.EmployeeRepository;
import com.example.Assignment4.entity.Employee;
import com.example.Assignment4.entity.EmployeeType;
import com.example.Assignment4.event.SalaryChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalaryCalculatorService  implements SalaryCalculatorServiceInterface, ApplicationEventPublisherAware {
    @Autowired
    private EmployeeRepository employeeRepository;
    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getByType(EmployeeType employeeType) {
        return employeeRepository.findEmployeesByEmployeetype(employeeType);
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findEmployeesById(id);
    }

    @Override
    public void changeSalary(long id, double salary) {
        Employee employee = findById(id);
        employee.setFixedSalary(salary);
        employeeRepository.save(employee);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employee));
    }
    @Override
    public void changeHourRate(long id, double rate) {
        Employee employee = findById(id);
        employee.setHourRate(rate);
        employeeRepository.save(employee);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employee));
    }
    @Override
    public void changeCommRate(long id, float rate) {
        Employee employee = findById(id);
        employee.setCommRate(rate);
        employeeRepository.save(employee);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employee));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
