package com.yigitkula.EmployeService.service;

import com.yigitkula.EmployeService.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public Employee createEmp(Employee emp);
    public List<Employee> getEmployees();
    public Employee getEmployee(int id);
    public Employee updateEmployee(Employee emp, int id);
    public void deleteEmployee(int id);
    public void deleteAllEmploye();

}
