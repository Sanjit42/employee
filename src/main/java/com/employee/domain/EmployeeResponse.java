package com.employee.domain;

import com.employee.domain.skills.Consulting;
import com.employee.domain.skills.Domain;
import com.employee.domain.skills.Technical;
import com.employee.domain.skills.Testing;
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

  private Consulting consulting;
  private Domain domain;
  private Technical technical;
  private Testing testing;
}

