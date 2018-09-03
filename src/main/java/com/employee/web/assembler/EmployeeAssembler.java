package com.employee.web.assembler;

import java.util.Optional;

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

  public static Employee toEntity(Optional<EmployeeDto> employeeDto) {
    Employee employee = new Employee();

    employee.setName(employeeDto.get().getName());
    employee.setRole(employeeDto.get().getRole());
    employee.setGender(employeeDto.get().getGender());
    employee.setHomeOffice(employeeDto.get().getHomeOffice());
    employee.setEmployeeId(employeeDto.get().getEmployeeId());
    employee.setCurrentProject(employeeDto.get().getCurrentProject());

    return employee;
  }
}
