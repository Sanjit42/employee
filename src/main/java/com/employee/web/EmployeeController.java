package com.employee.web;

import com.employee.domain.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
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
}
