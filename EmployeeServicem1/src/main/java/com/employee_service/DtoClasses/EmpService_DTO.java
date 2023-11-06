package com.employee_service.DtoClasses;

import com.employee_service.entity.EmpAddress_entity;
import com.employee_service.entity.EmpClass_entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpService_DTO {

//    @Autowired
//    private EmpClass_entity employee;

    @Autowired
    private EmpResponse_service Employee;

    @Autowired
    private EmpAddress_entity Employee_address;



}
