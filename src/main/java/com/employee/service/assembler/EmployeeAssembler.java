package com.employee.service.assembler;

import com.employee.domain.Employee;
import com.employee.domain.EmployeeResponse;
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

  public static EmployeeResponse toEntity(EmployeeDto employeeDto) {

    EmployeeResponse employeeResponse = new EmployeeResponse();
    employeeResponse.setName(employeeDto.getName());
    employeeResponse.setRole(employeeDto.getRole());
    employeeResponse.setGender(employeeDto.getGender());
    employeeResponse.setHomeOffice(employeeDto.getHomeOffice());
    employeeResponse.setEmployeeId(employeeDto.getEmployeeId());
    employeeResponse.setCurrentProject(employeeDto.getCurrentProject());

    return employeeResponse;
  }
}
