package com.employee.web;

import java.util.List;

import com.employee.domain.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  private Employee employee;
  private List<Employee> employees;

  @Autowired
  private EmployeeService employeeService;

  @RequestMapping(path="/employee/add")
  public void addEmployee (@RequestBody Employee employee) {
    try {
      employeeService.save(employee);
    } catch (Exception e){
      e.getMessage();
    }
  }

  @GetMapping("/employee/{employeeId}")
  public Employee getEmployee (@PathVariable Long employeeId) {
    try {
      employee = employeeService.getEmployee(employeeId);
    } catch (Exception e){
      e.getMessage();
    }
    return employee;
  }

  @GetMapping("/employees")
  public List<Employee> getEmployees () {
    try {
      employees = employeeService.getEmployees();
    } catch (Exception e){
      e.getMessage();
    }
    return employees;
  }
}
