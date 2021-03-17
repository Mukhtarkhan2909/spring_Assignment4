package com.example.Assignment4.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {
    @Override
    @EventListener
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {
        System.out.println(salaryChangeEvent.employee.getName() + "'s salary information has changed.");
    }
}
