package com.employee.web;

import java.util.ArrayList;
import java.util.List;

import com.employee.domain.Employee;
import com.employee.model.EmployeeDto;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import com.employee.service.assembler.EmployeeAssembler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

  @Mock
  private EmployeeService employeeService;

  @Mock
  private EmployeeRepository employeeRepository;

  @InjectMocks
  private EmployeeController employeeController;

  @Test
  public void shouldThroughErrorIfRequestDataIsInvalid() {

    Employee employee = new Employee();

    employee.setRole("BA");
    employee.setGender("Male");
    employee.setCurrentProject("ABC");
    employee.setEmployeeId(12345L);

    ResponseEntity<Employee> response = employeeController.addEmployee(employee);

    assertThat(response.getStatusCode(), is(BAD_REQUEST));
  }

  @Test
  public void shouldSaveEmployeeWhenRequestDataAreValid() {
    Employee employee = new Employee();

    employee.setRole("BA");
    employee.setGender("Male");
    employee.setCurrentProject("ABC");

    EmployeeDto employeeDto = EmployeeAssembler.toDto(employee);

    when(employeeService.save(employee)).thenReturn(employee);
    when(employeeRepository.save(employeeDto)).thenReturn(employeeDto);

    ResponseEntity<Employee> response = employeeController.addEmployee(employee);

    assertThat(response.getStatusCode(), is(OK));
  }

  @Test
  public void shouldFindEmployeeByEmployeeId() {
    Employee employee = new Employee();
    employee.setRole("BA");
    employee.setGender("Male");
    employee.setEmployeeId(12345L);
    employee.setCurrentProject("ABC");

    EmployeeDto employeeDto = EmployeeAssembler.toDto(employee);

    when(employeeService.getEmployee(employee.getEmployeeId())).thenReturn(employee);
    when(employeeRepository.findByEmployeeId(employee.getEmployeeId())).thenReturn(employeeDto);

    Employee result = employeeController.getEmployee(12345L);

    assertEquals(employee.getEmployeeId(), result.getEmployeeId());
    assertEquals("Male", result.getGender());
  }

  @Test
  public void shouldReturnAllEmployees() {
    Employee employee = new Employee();
    employee.setRole("Dev");
    employee.setGender("Male");
    employee.setName("employee");
    employee.setEmployeeId(12345L);
    employee.setCurrentProject("ABC");

    Employee employee2 = new Employee();
    employee2.setRole("BA");
    employee2.setGender("Female");
    employee2.setName("employee2");
    employee2.setEmployeeId(12346L);
    employee2.setCurrentProject("DEF");

    List employeeList = new ArrayList();
    employeeList.add(employee);
    employeeList.add(employee2);

    when(employeeService.getEmployees()).thenReturn(employeeList);
    when(employeeRepository.findAll()).thenReturn(employeeList);

    List<Employee> result = employeeController.getEmployees();

    assertEquals(2, result.size());
    assertEquals("employee", result.get(0).getName());
    assertEquals("Male", result.get(0).getGender());
    assertEquals("ABC", result.get(0).getCurrentProject());

    assertEquals("employee2", result.get(1).getName());
    assertEquals("Female", result.get(1).getGender());
    assertEquals("DEF", result.get(1).getCurrentProject());
  }
}