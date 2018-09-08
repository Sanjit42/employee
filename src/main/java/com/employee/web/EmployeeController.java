package com.employee.web;

import java.util.List;

import com.employee.domain.Employee;
import com.employee.domain.EmployeeResponse;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class EmployeeController {

  private EmployeeResponse employee;
  private List<EmployeeResponse> employees;

  @Autowired
  private EmployeeService employeeService;

  @RequestMapping(path = "/employee/add")
  public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody Employee employee) {
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

  @GetMapping("/employee/{employeeId}")
  public EmployeeResponse getEmployee(@PathVariable Long employeeId) {
    try {
      employee = employeeService.getEmployee(employeeId);
    } catch (Exception e) {
      e.getMessage();
    }
    return employee;
  }

  @GetMapping("/employees")
  public List<EmployeeResponse> getEmployees() {
    try {
      employees = employeeService.getEmployees();
    } catch (Exception e) {
      e.getMessage();
    }
    return employees;
  }
}
