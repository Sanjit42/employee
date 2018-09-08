package com.employee.service.assembler;

import com.employee.domain.Employee;
import com.employee.domain.EmployeeResponse;
import com.employee.model.EmployeeDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeAssemblerTest {
  @Test
  public void shouldReturnEntityWithSameValuesAsDto() {
    EmployeeDto employeeDto = new EmployeeDto();

    employeeDto.setRole("BA");
    employeeDto.setName("Test");
    employeeDto.setHomeOffice("Hyderabad");
    employeeDto.setCurrentProject("ABC");
    employeeDto.setGender("Male");
    employeeDto.setEmployeeId(12345L);

    EmployeeResponse employeeResponse = EmployeeAssembler.toEntity(employeeDto);

    assertEquals("Hyderabad", employeeResponse.getHomeOffice());
    assertEquals("Test", employeeResponse.getName());
  }

  @Test
  public void shouldReturnDtoWithSameValuesAsEntity() {
    Employee employee = new Employee(
            "Employee",
            12345L,
            "Dev",
            "Male",
            "Hyderabad",
            "t"
    );

    EmployeeDto employeeDto = EmployeeAssembler.toDto(employee);

    assertEquals("Dev", employeeDto.getRole());
    assertEquals("Employee", employeeDto.getName());
    assertEquals("Hyderabad", employeeDto.getHomeOffice());
  }
}