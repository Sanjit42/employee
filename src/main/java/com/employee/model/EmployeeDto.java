package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
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

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getHomeOffice() {
    return homeOffice;
  }

  public void setHomeOffice(String homeOffice) {
    this.homeOffice = homeOffice;
  }

  public String getCurrentProject() {
    return currentProject;
  }

  public void setCurrentProject(String currentProject) {
    this.currentProject = currentProject;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getId() {
    return String.valueOf(id);
  }

  public void setId(Long id) {
    this.id = id;
  }
}
