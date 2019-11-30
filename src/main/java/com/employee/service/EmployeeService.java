package com.employee.service;

import com.employee.Utils;
import com.employee.repository.SkillRepository;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.employee.domain.Employee;
import com.employee.domain.EmployeeResponse;
import com.employee.domain.EmployeeSkills;
import com.employee.model.EmployeeDto;
import com.employee.repository.EmployeeRepository;
import com.employee.service.assembler.EmployeeAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
  private final long range = 99999L;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private SkillRepository skillRepository;

  public EmployeeResponse save(Employee employee) {
    EmployeeDto employeeDto = EmployeeAssembler.toDto(employee);

    long employeeId = generateEmployeeId();
    employeeDto.setEmployeeId(employeeId);

    EmployeeDto saveEmployee = employeeRepository.save(employeeDto);

    createDefaultSkill(saveEmployee.getEmployeeId());

    return EmployeeAssembler.toEntity(saveEmployee);
  }

  private void createDefaultSkill(Long employeeId) {
    EmployeeSkills employeeSkills = Utils.setDefaultSkills(employeeId);
    skillRepository.save(employeeSkills);
  }

  public List<EmployeeResponse> getEmployees() {
    List<EmployeeDto> employees = employeeRepository.findAll();
    return employees.stream().map(EmployeeAssembler::toEntity).collect(Collectors.toList());
  }

  public EmployeeSkills getEmployeeSkills(Long employeeId) {
    EmployeeSkills employeeSkills = skillRepository.findByEmployeeId(employeeId);
    return employeeSkills;
  }

  public List<EmployeeSkills> getEmployeesSkills() {
    List<EmployeeDto> employees = employeeRepository.findAll();
    List<EmployeeSkills> employeeSkills =
      employees.stream()
        .map(employee -> getEmployeeSkills(employee.getEmployeeId()))
           .collect(Collectors.toList());
    return employeeSkills;
  }

  private long generateEmployeeId() {
    Random random = new Random();
    return  (long) (random.nextDouble() * range);
  }

  public EmployeeSkills updateSkills(EmployeeSkills employeeSkills) {
    return skillRepository.save(employeeSkills);
  }
}
