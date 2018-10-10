package com.employee.domain;

import com.employee.domain.skills.Consulting;
import com.employee.domain.skills.Domain;
import com.employee.domain.skills.Technical;
import com.employee.domain.skills.Testing;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EmployeeSkills {
  private Long employeeId;

  private Consulting consulting;
  private Domain domain;
  private Technical technical;
  private Testing testing;
}
