package com.employeeservice.serviceimpl;

import com.employeeservice.entity.Employee;
import com.employeeservice.exception.EmployeeAlreadyExist;
import com.employeeservice.exception.EmployeeIdNotFound;
import com.employeeservice.payload.EmployeeDto;
import com.employeeservice.repository.EmployeeRepository;
import com.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee){
        Optional<Employee> byEmailId = Optional.ofNullable(employeeRepository.findByEmailId(employee.getEmailId()));
        if(byEmailId.isPresent()){
            throw new EmployeeAlreadyExist("Employee with email Id already exists");
        }else{

            return employeeRepository.save(employee);
        }
    }

    @Override
    public String deleteEmployee(long id) {
        employeeRepository.deleteById(id);
        return "Data deleted successfully";
    }

    @Override
    public Employee updateEmployee(long id, EmployeeDto employeeDto) {
        Optional<Employee> byId = employeeRepository.findById(id);
       Employee employee =byId.get();
       employee.setName(employeeDto.getName());
       employee.setEmailId(employeeDto.getEmailId());
       return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return  employeeRepository.findAll();
    }

    @Override
    public Iterable<Employee> findEmployeeByIdOrName(Long id, String name) {
        Iterable<Employee> employeeByIdOrName = employeeRepository.findEmployeeByIdOrName(id, name);
            return employeeByIdOrName;
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        if(byId.isPresent()){
            Employee employee = byId.get();
            return employee;
        }else{
           throw new EmployeeIdNotFound("Employee not found with id:" +id);
        }
    }
}
