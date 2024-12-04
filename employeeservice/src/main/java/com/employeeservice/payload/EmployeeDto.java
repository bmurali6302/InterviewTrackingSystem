package com.employeeservice.payload;

import lombok.Data;

@Data
public class EmployeeDto {
    private long id;
    private String name;
    private String emailId;
}
