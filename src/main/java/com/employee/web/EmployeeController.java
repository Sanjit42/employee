package com.employee.web;

import java.util.List;

import com.employee.domain.Employee;
import com.employee.domain.EmployeeResponse;
import com.employee.domain.EmployeeSkills;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class EmployeeController {

  private List<EmployeeResponse> employees;
  private List<EmployeeSkills> employeesSkills;

  @Autowired private EmployeeService employeeService;

  @CrossOrigin
  @PostMapping("/employee")
  public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody Employee employee) {
    try {
      if (employee.getEmployeeId() != null) {
        return new ResponseEntity<>(BAD_REQUEST);
      }
      EmployeeResponse responseEmployee = employeeService.save(employee);

      return new ResponseEntity<>(responseEmployee, OK);

    } catch (Exception e) {
      return new ResponseEntity<>(BAD_REQUEST);
    }
  }

  @CrossOrigin
  @GetMapping("/employees")
  public List<EmployeeResponse> getEmployees() {
    try {
      employees = employeeService.getEmployees();
    } catch (Exception e) {
      e.getMessage();
    }
    return employees;
  }

  @CrossOrigin
  @GetMapping("/employees/skills")
  public List<EmployeeSkills> getEmployeesSkills() {
    try {
      employeesSkills = employeeService.getEmployeesSkills();
    } catch (Exception e) {
      e.getStackTrace();
    }
    return employeesSkills;
  }

  @CrossOrigin
  @PutMapping("/employee/skills")
  public EmployeeSkills updateSkills(@RequestBody EmployeeSkills employeeSkills) {
    return employeeService.updateSkills(employeeSkills);
  }
}
