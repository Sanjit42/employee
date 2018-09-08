package com.employee.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
  private String name;
  private Long employeeId;
  private String role;
  private String gender;
  private String homeOffice;
  private String currentProject;
}

