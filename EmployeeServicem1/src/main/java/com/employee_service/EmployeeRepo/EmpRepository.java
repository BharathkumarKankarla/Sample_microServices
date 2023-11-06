package com.employee_service.EmployeeRepo;

import com.employee_service.entity.EmpClass_entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmpRepository extends MongoRepository<EmpClass_entity, Long> {
    EmpClass_entity findByEmpId(long empId);

    @Query(value = "{ 'empId': ?0 }", fields = "{ 'empName': 1 }")
    String findNameByEmpId(long empId);

}
