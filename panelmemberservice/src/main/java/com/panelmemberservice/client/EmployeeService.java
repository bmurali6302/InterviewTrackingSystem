package com.panelmemberservice.client;

import com.panelmemberservice.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employee-service", url = "http://localhost:8099")
public interface EmployeeService {


    @GetMapping("/api/v1/employee/search/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id);
}
