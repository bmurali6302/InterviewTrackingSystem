package com.panelmemberservice.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDto {
    private Long id;
    private String name;
    private String emailId;
}
