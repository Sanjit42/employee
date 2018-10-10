package com.employee.repository;

import com.employee.domain.skills.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Long> {
  Domain findByEmployeeId(Long employeeId);
}
