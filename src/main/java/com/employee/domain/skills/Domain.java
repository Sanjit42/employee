package com.employee.domain.skills;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity(name = "domain")
@Data
public class Domain {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "government")
  private int government;

  @Column(name = "education")
  private int education;

  @Column(name = "employee_id")
  private Long employeeId;
}
