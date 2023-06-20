package com.example.SpringTask.Service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SpringTask.Entity.Employee;
import com.example.SpringTask.Repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepo;

    public Employee createEmployee(Employee emp)
    {
        return empRepo.save(emp);
    }

    public Employee getEmployeeById(Long empId) {
        Optional<Employee> optionalEmployee = empRepo.findById(empId);
        return optionalEmployee.get();
    }
    public List<Employee> getAllEmployee()
    {
        return empRepo.findAll();

    }

    public Employee updateEmployee(Employee emp)
    {
        Employee existingEmp = empRepo.findById(emp.getEid()).get();
        //existingEmp.setEid(emp.getEid());
        existingEmp.setEname(emp.getEname());
        existingEmp.setSalary(emp.getSalary());
        Employee updatedEmp = empRepo.save(existingEmp);
        return updatedEmp;
    }
    public void deleteEmployee(Long empId)
    {
        empRepo.deleteById(empId);
    }

//    public void deleteEmployeeByName(String ename) {
//        empRepo.deleteByName(ename);
//    }

}
