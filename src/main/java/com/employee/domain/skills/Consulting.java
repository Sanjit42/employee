package com.employee.domain.skills;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Consulting {
  @Column(name = "communication")
  private int communication;

  @Column(name = "planning")
  private int planning;

  @Column(name = "questioning")
  private int questioning;
}
