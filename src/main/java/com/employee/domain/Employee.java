package com.employee.domain;

import javax.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class Employee {

  @NotBlank(message = "{Employee.name.required}")
  private String name;

  @NotBlank(message = "{Employee.employeeId.required}")
  private Long employeeId;

  @NotBlank(message = "{Employee.role.required}")
  private String role;

  @NotBlank(message = "{Employee.gender.required}")
  private String gender;

  @NotBlank(message = "{Employee.homeOffice.required}")
  private String homeOffice;

  @NotBlank(message = "{Employee.currentProject.required}")
  private String currentProject;
}
