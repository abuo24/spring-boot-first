package com.example.demo.webRes;


import com.example.demo.Service.EmployeeService;
import com.example.demo.domain.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResources {

    private final EmployeeService employeeService;

    public EmployeeResources(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity creat(@RequestBody Employee employee){
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }
    @GetMapping("/employees")
    public ResponseEntity getAll(){
        List<Employee> employeeList = employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }
    @GetMapping("/employees/{name}")
    public ResponseEntity getName(@PathVariable String name){
        List<Employee> employeeList = employeeService.findByName(name);
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/employees/search")
    public ResponseEntity getAllSearch(@RequestParam String name){
        List<Employee> employeeList = employeeService.findByAllParam(name);
        return ResponseEntity.ok(employeeList);
    }


    @PutMapping("/employees")
    public ResponseEntity update(@RequestBody Employee employee){
        if (employee.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("Ok");
    }



}
