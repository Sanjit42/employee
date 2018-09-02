package com.employee.repository;

import com.employee.model.EmployeeDto;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeDto, Integer> {
}
