package com.tkhts.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<Employee>() {
        {
            add(new Employee(1, "John", 1000));
            add(new Employee(2, "Jane", 2000));
        }
    };

    @GetMapping("/")
    public List<Employee> getEmployees() {
        return employees;
    }

    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        employees.add(newEmployee);
        return newEmployee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(updatedEmployee.getName());
                employee.setSalary(updatedEmployee.getSalary());
                return employee;
            }
        }
        return null;
    }

    @PatchMapping("/{id}")
    public Employee updateEmployeeSalary(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setSalary(updatedEmployee.getSalary());
                // System.err.println("Employee: " + employee.toString());
                return employee;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                return employee;
            }
        }
        return null;
    }
}