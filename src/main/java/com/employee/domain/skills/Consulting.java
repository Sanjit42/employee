package com.employee.domain.skills;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Consulting {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "communication")
  private int communication;

  @Column(name = "planning")
  private int planning;

  @Column(name = "questioning")
  private int questioning;

  @Column(name = "employee_id")
  private Long employeeId;
}
