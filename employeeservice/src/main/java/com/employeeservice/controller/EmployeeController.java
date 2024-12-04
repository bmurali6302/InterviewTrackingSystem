package com.employeeservice.controller;

import com.employeeservice.entity.Employee;
import com.employeeservice.payload.EmployeeDto;
import com.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>>  getAllEmployee(){
        List<Employee> allEmployee = employeeService.getAllEmployee();
        return new ResponseEntity<>(allEmployee,HttpStatus.OK);

    }
    @PutMapping ("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody EmployeeDto employeeDto){
        Employee employee = employeeService.updateEmployee(id, employeeDto);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteEmployee(@PathVariable long id){
            String s = employeeService.deleteEmployee(id);
            return new ResponseEntity<>(s,HttpStatus.OK);
    }
    @GetMapping("/search/{id}/{name}")
    public ResponseEntity<Iterable<Employee>> fidEmployeeByIdOrName(@PathVariable long id,@PathVariable String name){
        Iterable<Employee> employeeByIdOrName = employeeService.findEmployeeByIdOrName(id, name);

        return new ResponseEntity<>(employeeByIdOrName,HttpStatus.OK);
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employeeById = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employeeById,HttpStatus.OK);
    }



}
