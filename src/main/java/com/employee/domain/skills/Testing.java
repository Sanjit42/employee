package com.employee.domain.skills;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Embeddable
public class Testing {

  @Column(name = "capybara")
  private int capybara;

  @Column(name = "cucumber")
  private int cucumber;

  @Column(name = "fitness")
  private int fitness;
}
