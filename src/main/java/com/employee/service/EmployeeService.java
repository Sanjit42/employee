package com.employee.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.employee.domain.Employee;
import com.employee.domain.EmployeeResponse;
import com.employee.domain.EmployeeSkills;
import com.employee.domain.skills.Consulting;
import com.employee.domain.skills.Domain;
import com.employee.domain.skills.Technical;
import com.employee.domain.skills.Testing;
import com.employee.model.EmployeeDto;
import com.employee.repository.ConsultingRepository;
import com.employee.repository.DomainRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.TechnicalRepository;
import com.employee.repository.TestingRepository;
import com.employee.service.assembler.EmployeeAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
  private final long range = 99999L;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private ConsultingRepository consultingRepository;

  @Autowired
  private DomainRepository domainRepository;

  @Autowired
  private TechnicalRepository technicalRepository;

  @Autowired
  private TestingRepository testingRepository;

  public EmployeeResponse save(Employee employee) {
    EmployeeDto employeeDto = EmployeeAssembler.toDto(employee);

    long number = generateEmployeeId(employeeDto);
    createSkillsTable(number);

    EmployeeDto saveEmployee = employeeRepository.save(employeeDto);

    return EmployeeAssembler.toEntity(saveEmployee);
  }

  public List<EmployeeResponse> getEmployees() {
    List<EmployeeDto> employees = employeeRepository.findAll();
    return employees.stream().map(EmployeeAssembler::toEntity).collect(Collectors.toList());
  }

  public EmployeeSkills getEmployeeSkills(Long employeeId) {
    EmployeeSkills employeeSkills = new EmployeeSkills();
    employeeSkills.setEmployeeId(employeeId);

    Consulting consultingDetails = consultingRepository.findByEmployeeId(employeeId);
    Domain domainDetails = domainRepository.findByEmployeeId(employeeId);
    Technical technicalDetails = technicalRepository.findByEmployeeId(employeeId);
    Testing testingDetails = testingRepository.findByEmployeeId(employeeId);

    employeeSkills.setConsulting(consultingDetails);
    employeeSkills.setDomain(domainDetails);
    employeeSkills.setTechnical(technicalDetails);
    employeeSkills.setTesting(testingDetails);

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

  private long generateEmployeeId(EmployeeDto employeeDto) {
    Random random = new Random();
    long number = (long) (random.nextDouble() * range);
    employeeDto.setEmployeeId(number);
    return number;
  }

  private void createSkillsTable(Long employeeId) {
    insertConsultingSkills(employeeId);
    insertDomainSkills(employeeId);
    insertTechnicalSkills(employeeId);
    insertTestingSkills(employeeId);
  }

  private void insertConsultingSkills(Long employeeId) {
    Consulting consulting = new Consulting();
    consulting.setEmployeeId(employeeId);
    consultingRepository.save(consulting);
  }

  private void insertDomainSkills(Long employeeId) {
    Domain domain = new Domain();
    domain.setEmployeeId(employeeId);
    domainRepository.save(domain);
  }

  private void insertTechnicalSkills(Long employeeId) {
    Technical technical = new Technical();
    technical.setEmployeeId(employeeId);
    technicalRepository.save(technical);
  }

  private void insertTestingSkills(Long employeeId) {
    Testing testing = new Testing();
    testing.setEmployeeId(employeeId);
    testingRepository.save(testing);
  }
}
