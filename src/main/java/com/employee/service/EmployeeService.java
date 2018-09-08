package com.employee.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.employee.domain.Employee;
import com.employee.domain.EmployeeResponse;
import com.employee.model.EmployeeDto;
import com.employee.repository.EmployeeRepository;
import com.employee.service.assembler.EmployeeAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
  private final long range = 99999L;

  @Autowired
  private EmployeeRepository employeeRepository;

  public EmployeeResponse save(Employee employee) {
    EmployeeDto employeeDto = EmployeeAssembler.toDto(employee);

    Random random = new Random();
    long number = (long) (random.nextDouble() * range);
    employeeDto.setEmployeeId(number);

    EmployeeDto saveEmployee = employeeRepository.save(employeeDto);

    return EmployeeAssembler.toEntity(saveEmployee);
  }

  public EmployeeResponse getEmployee(Long employeeId) {
    EmployeeDto employee = employeeRepository.findByEmployeeId(employeeId);
    return EmployeeAssembler.toEntity(employee);
  }

  public List<EmployeeResponse> getEmployees() {
    List<EmployeeDto> employees = employeeRepository.findAll();
    return employees
            .stream()
            .map(EmployeeAssembler::toEntity)
            .collect(Collectors.toList());
  }
}
