package com.svs.services.department.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.svs.services.department.model.Department;

@Repository
public interface DepartmentMongoRepository extends MongoRepository<Department, UUID> {
  Department save(Department department);
  Optional<Department> findById(Long id);
  List<Department> findAll();
  List<Department> findByOrganizationId(Long organizationId);

}
