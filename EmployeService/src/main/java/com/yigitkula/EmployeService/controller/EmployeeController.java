package com.yigitkula.EmployeService.controller;

import com.yigitkula.EmployeService.entity.Employee;
import com.yigitkula.EmployeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(service.getEmployees(), OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
        return new ResponseEntity<>(service.createEmp(emp), CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmploye(@PathVariable int id){
        return  new ResponseEntity<>(service.getEmployee(id), OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp){
        return new ResponseEntity<>(service.updateEmployee(emp, id), OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
        service.deleteEmployee(id);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("delete/all")
    public ResponseEntity<Void> deleteAllEmployees(){
        service.deleteAllEmploye();
        return new ResponseEntity<>(OK);
    }

}
