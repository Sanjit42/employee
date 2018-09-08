package com.employee.web;

import java.util.ArrayList;
import java.util.List;

import com.employee.domain.Employee;
import com.employee.domain.EmployeeResponse;
import com.employee.model.EmployeeDto;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import com.employee.service.assembler.EmployeeAssembler;
import org.junit.Before;
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

  private Employee employee;

  @Mock
  private EmployeeService employeeService;

  @Mock
  private EmployeeRepository employeeRepository;

  @InjectMocks
  private EmployeeController employeeController;

  @Before
  public void setUp() throws Exception {
    employee = new Employee(
            "employee",
            12345L,
            "Dev",
            "Male",
            "Hyderabad",
            "t"
    );
  }

  @Test
  public void shouldThroughErrorIfRequestDataIsInvalid() {

    ResponseEntity<EmployeeResponse> response = employeeController.addEmployee(employee);

    assertThat(response.getStatusCode(), is(BAD_REQUEST));
  }

  @Test
  public void shouldSaveEmployeeWhenRequestDataAreValid() {
    Employee employee = new Employee(
            "Employee",
            null,
            "Dev",
            "Male",
            "Hyderabad",
            "t"
    );

    EmployeeResponse employeeResponse = new EmployeeResponse();
    employeeResponse.setName("Employee");
    employeeResponse.setCurrentProject("Test");
    employeeResponse.setEmployeeId(null);
    employeeResponse.setGender("Female");

    EmployeeDto employeeDto = EmployeeAssembler.toDto(employee);

    when(employeeService.save(employee)).thenReturn(employeeResponse);
    when(employeeRepository.save(employeeDto)).thenReturn(employeeDto);

    ResponseEntity<EmployeeResponse> response = employeeController.addEmployee(employee);

    assertThat(response.getStatusCode(), is(OK));
  }

  @Test
  public void shouldFindEmployeeByEmployeeId() {

    EmployeeDto employeeDto = EmployeeAssembler.toDto(employee);

    EmployeeResponse employeeResponse = new EmployeeResponse();
    employeeResponse.setName("Employee");
    employeeResponse.setCurrentProject("Test");
    employeeResponse.setEmployeeId(12345L);
    employeeResponse.setGender("Female");

    when(employeeService.getEmployee(employee.getEmployeeId())).thenReturn(employeeResponse);
    when(employeeRepository.findByEmployeeId(employee.getEmployeeId())).thenReturn(employeeDto);

    EmployeeResponse result = employeeController.getEmployee(12345L);

    assertEquals(employeeResponse.getEmployeeId(), result.getEmployeeId());
    assertEquals("Female", result.getGender());
  }

  @Test
  public void shouldReturnAllEmployees() {

    List employeeList = new ArrayList();

    EmployeeResponse employeeResponse = new EmployeeResponse();
    employeeResponse.setName("Employee");
    employeeResponse.setEmployeeId(12345L);
    employeeResponse.setRole("Dev");
    employeeResponse.setGender("Male");
    employeeResponse.setCurrentProject("ABC");
    employeeResponse.setHomeOffice("Hyderabad");

    EmployeeResponse employeeResponse2 = new EmployeeResponse();
    employeeResponse2.setName("Employee2");
    employeeResponse2.setEmployeeId(12345L);
    employeeResponse2.setRole("Dev");
    employeeResponse2.setGender("Female");
    employeeResponse2.setCurrentProject("DEF");
    employeeResponse2.setHomeOffice("Hyderabad");

    employeeList.add(employeeResponse);
    employeeList.add(employeeResponse2);

    when(employeeService.getEmployees()).thenReturn(employeeList);
    when(employeeRepository.findAll()).thenReturn(employeeList);

    List<EmployeeResponse> result = employeeController.getEmployees();

    assertEquals(2, result.size());
    assertEquals("Employee", result.get(0).getName());
    assertEquals("Male", result.get(0).getGender());
    assertEquals("ABC", result.get(0).getCurrentProject());

    assertEquals("Employee2", result.get(1).getName());
    assertEquals("Female", result.get(1).getGender());
    assertEquals("DEF", result.get(1).getCurrentProject());
  }
}