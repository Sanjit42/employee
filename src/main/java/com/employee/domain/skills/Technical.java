package com.employee.domain.skills;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Technical {

  @Column(name = "AWS")
  private int AWS;

  @Column(name = "java")
  private int java;
}
