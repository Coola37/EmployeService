package com.yigitkula.EmployeService.service;

import com.yigitkula.EmployeService.entity.Employee;
import com.yigitkula.EmployeService.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository repo;
    @Override
    public Employee createEmp(Employee emp) {
        return repo.save(emp);
    }

    @Override
    public List<Employee> getEmployees() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee updateEmployee(Employee emp, int id) {
        Employee old = repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

        old.setMail(emp.getMail());
        old.setSalary(emp.getSalary());
        old.setFirstName(emp.getFirstName());
        old.setLastName(emp.getLastName());
        repo.save(old);

        return old;
    }

    @Override
    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }

    @Override
    public void deleteAllEmploye() {
        repo.deleteAll();
    }


}
