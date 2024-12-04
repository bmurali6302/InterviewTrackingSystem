package com.employeeservice.repository;

import com.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

   public Employee findByEmailId(String emailId);

   @Query("select e from Employee e where e.id=:x or e.name=:y")
   public Iterable<Employee> findEmployeeByIdOrName(@Param("x") Long id, @Param("y") String name);
}