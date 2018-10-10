package com.employee.domain.skills;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Testing {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "capybara")
  private int capybara;

  @Column(name = "cucumber")
  private int cucumber;

  @Column(name = "fitness")
  private int fitness;

  @Column(name = "employee_id")
  private Long employeeId;
}
