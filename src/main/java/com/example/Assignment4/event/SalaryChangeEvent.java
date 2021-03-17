package com.example.Assignment4.event;

import com.example.Assignment4.entity.Employee;
import com.example.Assignment4.service.SalaryCalculatorService;
import com.example.Assignment4.service.SalaryCalculatorServiceInterface;
import org.springframework.context.ApplicationEvent;

public class SalaryChangeEvent extends ApplicationEvent {

    Employee employee;
    public SalaryChangeEvent(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

}
