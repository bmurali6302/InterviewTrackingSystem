package com.employeeservice.service;

import com.employeeservice.entity.Employee;
import com.employeeservice.payload.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public Employee addEmployee(Employee employee);
    public String deleteEmployee(long id);
    public Employee updateEmployee(long id, EmployeeDto employeeDto);
    public List<Employee> getAllEmployee();

    public Iterable<Employee> findEmployeeByIdOrName(Long id, String name);
    public Employee findEmployeeById(Long id);
}
