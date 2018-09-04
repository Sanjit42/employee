package com.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import com.employee.domain.Employee;
import com.employee.model.EmployeeDto;
import com.employee.repository.EmployeeRepository;
import com.employee.service.assembler.EmployeeAssembler;
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

  public Employee getEmployee(Long employeeId) {
    EmployeeDto employee = employeeRepository.findByEmployeeId(employeeId);
    return EmployeeAssembler.toEntity(employee);
  }

  public List<Employee> getEmployees() {
    List<EmployeeDto> employees = employeeRepository.findAll();
    return employees
            .stream()
            .map(EmployeeAssembler::toEntity)
            .collect(Collectors.toList());
  }
}
