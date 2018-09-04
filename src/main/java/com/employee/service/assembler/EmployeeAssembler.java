package com.employee.service.assembler;

import com.employee.domain.Employee;
import com.employee.model.EmployeeDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EmployeeAssembler {
  public static EmployeeDto toDto(Employee employee) {
    EmployeeDto employeeDto = new EmployeeDto();

    employeeDto.setName(employee.getName());
    employeeDto.setRole(employee.getRole());
    employeeDto.setGender(employee.getGender());
    employeeDto.setHomeOffice(employee.getHomeOffice());
    employeeDto.setEmployeeId(employee.getEmployeeId());
    employeeDto.setCurrentProject(employee.getCurrentProject());

    return employeeDto;
  }

  public static Employee toEntity(EmployeeDto employeeDto) {
    Employee employee = new Employee();

    employee.setName(employeeDto.getName());
    employee.setRole(employeeDto.getRole());
    employee.setGender(employeeDto.getGender());
    employee.setHomeOffice(employeeDto.getHomeOffice());
    employee.setEmployeeId(employeeDto.getEmployeeId());
    employee.setCurrentProject(employeeDto.getCurrentProject());

    return employee;
  }
}
