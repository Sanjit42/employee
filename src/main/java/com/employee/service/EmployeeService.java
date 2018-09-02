package com.employee.service;

import com.employee.domain.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public void save(Employee employee) {
    employeeRepository.save(employee);
  }
}
