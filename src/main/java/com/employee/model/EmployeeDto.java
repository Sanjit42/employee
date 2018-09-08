package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class EmployeeDto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  @Size(min = 1, max = 100)
  private String name;

  @Column(unique = true, name = "employee_id")
  @Size(min = 5, max = 5)
  private Long employeeId;


  @Column(name = "role")
  @Size(min = 2, max = 30)
  private String role;

  @Column(name = "gender")
  @Size(min = 1, max = 5)
  private String gender;

  @Column(name = "home_office")
  @Size(min = 2, max = 100)
  private String homeOffice;

  @Column(name = "current_project")
  @Size(min = 2, max = 100)
  private String currentProject;
}
