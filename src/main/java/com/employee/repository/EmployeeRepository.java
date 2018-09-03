package com.employee.repository;

import java.util.List;
import java.util.Optional;

import com.employee.model.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDto, Long> {
  public Optional<EmployeeDto> findByEmployeeId(Long employeeId);
}
