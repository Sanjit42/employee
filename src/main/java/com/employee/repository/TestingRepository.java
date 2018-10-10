package com.employee.repository;

import com.employee.domain.skills.Testing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestingRepository extends JpaRepository<Testing, Long> {
  Testing findByEmployeeId(Long employeeId);
}
