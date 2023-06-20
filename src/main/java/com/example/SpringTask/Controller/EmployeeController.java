package com.example.SpringTask.Controller;


import com.example.SpringTask.Entity.Employee;
import com.example.SpringTask.Repository.EmployeeRepository;
import com.example.SpringTask.Service.EmployeeService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/details")
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    EmployeeService empSer;
    EmployeeRepository empRepo;

    @PostMapping("/add/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
        Employee savedEmp = empSer.createEmployee(emp);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long empId) {
        Employee emp = empRepo.getById(empId);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }


    @GetMapping("/all/employee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> emps = empSer.getAllEmployee();
        System.out.println(emps);
        return new ResponseEntity<>(emps, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long empId, @RequestBody Employee emp) {
        emp.setEid(empId);
        Employee updatedEmp = empSer.updateEmployee(emp);
        return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long empId) {
        empSer.deleteEmployee(empId);
        return new ResponseEntity<>("Employee successfully deleted", HttpStatus.OK);
    }

}
