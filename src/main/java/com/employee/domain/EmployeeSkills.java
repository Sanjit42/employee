package com.employee.domain;

import com.employee.domain.skills.Consulting;
import com.employee.domain.skills.Domain;
import com.employee.domain.skills.Technical;
import com.employee.domain.skills.Testing;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EmployeeSkills {
  @Id
  private Long employeeId;

  @Embedded
  private Consulting consulting;

  @Embedded
  private Domain domain;

  @Embedded
  private Technical technical;

  @Embedded
  private Testing testing;

}
