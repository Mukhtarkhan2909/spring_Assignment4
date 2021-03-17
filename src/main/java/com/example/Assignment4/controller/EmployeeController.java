package com.example.Assignment4.controller;

import com.example.Assignment4.entity.Employee;
import com.example.Assignment4.entity.EmployeeType;
import com.example.Assignment4.service.SalaryCalculatorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Controller
public class EmployeeController {
    Scanner s = new Scanner(System.in).useLocale(Locale.US);
    @Autowired
    SalaryCalculatorServiceInterface salaryCalculatorServiceInterface;
    private static final DecimalFormat format = new DecimalFormat("#.##");
    @PostConstruct
    public void showMenu() {
        int c = 0;
        while (c != 6) {
            int i;
            System.out.println("""
                    \tChoose operation
                    1. Change hour rate of employee
                    2. Change commission tate of employee
                    3. Change salary of employee
                    4. Calculate employees salaries
                    5. List of all employees
                    6. Exit""");
            c = s.nextInt();
            switch (c) {
                case 1 -> {
                    System.out.println("Enter employee id");
                    int id = s.nextInt();
                    System.out.println("Enter the new hour rate");
                    double rate = s.nextDouble();
                    salaryCalculatorServiceInterface.changeHourRate(id, rate);
                }
                case 2 -> {
                    System.out.println("Enter employee id");
                    int id = s.nextInt();
                    System.out.println("Enter the new commission rate");
                    float rate = s.nextFloat();
                    salaryCalculatorServiceInterface.changeCommRate(id, rate);
                }
                case 3 -> {
                    System.out.println("Enter employee id");
                    int id = s.nextInt();
                    System.out.println("Enter the new salary");
                    double salary = s.nextDouble();
                    salaryCalculatorServiceInterface.changeSalary(id, salary);
                }
                case 4 -> {
                    System.out.println("SALARIED employees");
                    List<Employee> employees = salaryCalculatorServiceInterface.getByType(EmployeeType.SALARIED);
                    System.out.println("\t" + employees.size() + " employees found.");
                    i = 1;
                    for (Employee employee : employees) {
                        System.out.println(i + ") " + employee.getName() + ": " + employee.getFixedSalary() + " tenges");
                        i++;
                    }
                    System.out.println("\tHOURLY employees");
                    employees = salaryCalculatorServiceInterface.getByType(EmployeeType.HOURLY);
                    System.out.println(" \t\t" + employees.size() + " employees found.");
                    i = 1;
                    for (Employee employee : employees) {
                        double salary = employee.getFixedSalary();
                        int hours = employee.getHoursWorked();
                        if (hours > 40) {
                            System.out.println(i + ") " + employee.getName() + ": " +
                                    (salary * 40 + (hours - 40) * salary * employee.getHourRate()) + " (worked " + hours + " hours)");
                        } else {
                            System.out.println(i + ") " + employee.getName() + ": " + salary * hours);
                        }
                        i++;
                    }
                    System.out.println("\tCOMMISSION employees");
                    employees = salaryCalculatorServiceInterface.getByType(EmployeeType.COMMISSION);
                    System.out.println("\t\t" + employees.size() + " employees found.");
                    i = 1;
                    for (Employee employee : employees) {
                        double salary = (employee.getFixedSalary() * employee.getCommRate());
                        System.out.println(i + ") " + employee.getName() + ": " + format.format(salary) + " tenges");
                        i++;
                    }
                    System.out.println("\tSALARIED COMMISSION employees");
                    employees = salaryCalculatorServiceInterface.getByType(EmployeeType.SALARIED_COMMISSION);
                    System.out.println("\t\t" + employees.size() + " employees found.");
                    i = 1;
                    for (Employee employee : employees) {
                        double salary = ((employee.getFixedSalary() + employee.getCommRate() * employee.getFixedSalary()));
                        System.out.println(i + ") " + employee.getName() + ": " + format.format(salary) + " tenges");
                        i++;
                    }
                    System.out.println();
                }
                case 5 -> {
                    List<Employee> employees = salaryCalculatorServiceInterface.findAll();
                    System.out.println("\tTotal number of employees: " + employees.size());
                    for (Employee employee : employees) {
                        String name = employee.getName();
                        long id = employee.getId();
                        double salary = employee.getFixedSalary();
                        double hourRate = employee.getHourRate();
                        float commRate = employee.getCommRate();
                        System.out.println("ID: " + id +
                                "\t\tName: " + name +
                                "\t\tType: " + employee.getEmployeeType() +
                                "\t\tSalary: " + format.format(salary) +
                                "\t\tHour rate: " + format.format(hourRate) +
                                "\t\tCommission rate: " + format.format(commRate));
                    }
                }
            }
        }
    }
}
