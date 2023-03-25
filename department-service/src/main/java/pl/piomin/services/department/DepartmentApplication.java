package pl.piomin.services.department;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import pl.piomin.services.department.model.Department;
import pl.piomin.services.department.repository.DepartmentMongoRepository;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class DepartmentApplication implements CommandLineRunner {

  @Autowired
  DepartmentMongoRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(DepartmentApplication.class, args);
  }

  @Bean
  public Docket swaggerPersonApi10() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("pl.piomin.services.department.controller"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(new ApiInfoBuilder().version("1.0").title("Department API")
            .description("Documentation Department API v1.0").build());
  }

  @Override
  public void run(String... args)  {
    repository.deleteAll();
    repository.save(new Department(1L, 1L, "Operations", Collections.emptyList()));
    repository.save(new Department(2L, 1L, "Operations", Collections.emptyList()));
    repository.save(new Department(3L, 2L, "Development", Collections.emptyList()));
    repository.save(new Department(4L, 2L, "Operations", Collections.emptyList()));
  }


}
