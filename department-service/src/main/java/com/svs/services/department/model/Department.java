package com.svs.services.department.model;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@SuperBuilder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Document(collection = "Department")
@Table
public class Department {

  private Long Id;
  private Long organizationId;
  private String name;
  private List<Employee> employees = new ArrayList<>();

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    return "Department [id=" + ", organizationId=" + organizationId + ", name=" + name + "]";
  }

}
