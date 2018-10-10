package com.employee.repository;

import com.employee.domain.skills.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepository extends JpaRepository<Technical, Long> {
  Technical findByEmployeeId(Long employeeId);
}
