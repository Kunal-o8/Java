package com.tkhts.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    // Get to return XML and JSON
    @GetMapping(path = "/", produces = { MediaType.ALL_VALUE }, consumes = MediaType.ALL_VALUE)
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee newEmployee) {
        employees.add(newEmployee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(updatedEmployee.getName());
                employee.setSalary(updatedEmployee.getSalary());
                return new ResponseEntity<>(employee, HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeSalary(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setSalary(updatedEmployee.getSalary());
                return new ResponseEntity<>(employee, HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                return new ResponseEntity<>(employee, HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}