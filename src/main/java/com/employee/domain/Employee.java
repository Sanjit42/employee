package com.employee.domain;

import javax.validation.constraints.NotBlank;

public class Employee {

  @NotBlank(message = "{Employee.name.required}")
  private String name;

  @NotBlank(message = "{Employee.employeeId.required}")
  private String employeeId;


  @NotBlank(message = "{Employee.role.required}")
  private String role;

  @NotBlank(message = "{Employee.gender.required}")
  private String gender;

  @NotBlank(message = "{Employee.homeOffice.required}")
  private String homeOffice;

  @NotBlank(message = "{Employee.currentProject.required}")
  private String currentProject;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
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
}
