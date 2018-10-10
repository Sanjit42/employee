package com.employee.repository;

import com.employee.domain.skills.Consulting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultingRepository extends JpaRepository<Consulting, Long> {
  Consulting findByEmployeeId(Long employeeId);
}
