package com.example.demo.Service;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void delete(Long id){
        Employee employee = employeeRepository.getOne(id);
        employeeRepository.delete(employee);
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Long id){
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findByName(String name){
        return employeeRepository.findByNameQueryNative(name);
    }
    public List<Employee> findByAllParam(String name){
        return employeeRepository.findAllByLike(name);
    }
//    public List<Employee> findByName(String name){
//        return employeeRepository.findByNameQueryNative(name);
//    }
//    public List<Employee> findByName(String name){
//        return employeeRepository.findByNameQueryNative(name);
//    }
//    public List<Employee> findByName(String name){
//        return employeeRepository.findByName(name);
//    }


//    @Scheduled(cron = "50 14 0  * * *")
//    public Employee saveSchudele(){
//        Employee employee1 = new Employee();
//        employee1.setName("employee ");
//        employee1.setLastName("auto save");
//        return employeeRepository.save(employee1);
//    }


}
