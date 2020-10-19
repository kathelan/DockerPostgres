package com.git.postgres.springbootpostgresdocker.controller;

import com.git.postgres.springbootpostgresdocker.EmployeeRepository;
import com.git.postgres.springbootpostgresdocker.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PostMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmployeeId(@PathVariable(value = "id") Integer id) {

        Employee employee =  employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundExeption("Employee not found" +id));
                return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Integer id)  {

        Employee employee =  employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundExeption("Employee not found" +id));
        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
