package com.employee.domain.skills;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Embeddable
public class Domain {

  @Column(name = "government")
  private int government;

  @Column(name = "education")
  @ColumnDefault("0")
  private int education;
}
