package com.employee.service;

import java.util.Optional;

import com.employee.domain.Employee;
import com.employee.model.EmployeeDto;
import com.employee.repository.EmployeeRepository;
import com.employee.web.assembler.EmployeeAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public void save(Employee employee) {
    EmployeeDto employeeDto = EmployeeAssembler.toDto(employee);
    employeeRepository.save(employeeDto);
  }

  public Employee getEmployeeById(Long employeeId) {
    Optional<EmployeeDto> employee = employeeRepository.findByEmployeeId(employeeId);
    return EmployeeAssembler.toEntity(employee);
  }
}
