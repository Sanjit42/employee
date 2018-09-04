package com.employee.repository;

import com.employee.model.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDto, Long> {
  public EmployeeDto findByEmployeeId(Long employeeId);
}
