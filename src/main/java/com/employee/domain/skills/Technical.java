package com.employee.domain.skills;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Technical {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "AWS")
  private int AWS;

  @Column(name = "java")
  private int java;

  @Column(name = "employee_id")
  private Long employeeId;
}
