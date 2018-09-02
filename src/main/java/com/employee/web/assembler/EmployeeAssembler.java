package com.employee.web.assembler;

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
}
