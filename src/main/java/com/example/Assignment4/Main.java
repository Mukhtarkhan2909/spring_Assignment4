package com.example.Assignment4;
import com.example.Assignment4.configuration.SpringConfiguration;
import com.example.Assignment4.controller.EmployeeController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        EmployeeController employeeController = context.getBean("employeeController", EmployeeController.class);
    }
}
