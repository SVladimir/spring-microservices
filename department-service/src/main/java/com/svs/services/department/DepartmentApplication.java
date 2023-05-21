package com.svs.services.department;

import com.svs.services.department.model.Department;
import com.svs.services.department.repository.DepartmentMongoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@OpenAPIDefinition(info =
@Info(title = "Department API", version = "1.0", description = "Documentation Department API v1.0")
)
public class DepartmentApplication implements CommandLineRunner {

  @Autowired
  DepartmentMongoRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(DepartmentApplication.class, args);
  }


  @Override
  public void run(String... args) {
    repository.deleteAll();
    repository.save(new Department(1L, 1L, "Operations", Collections.emptyList()));
    repository.save(new Department(2L, 1L, "Operations", Collections.emptyList()));
    repository.save(new Department(3L, 2L, "Development", Collections.emptyList()));
    repository.save(new Department(4L, 2L, "Operations", Collections.emptyList()));
  }


}
