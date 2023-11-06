package com.employee_service.DtoClasses;

import com.employee_service.FeignClients.EmployeeAddress_client;
import com.employee_service.entity.EmpAddress_entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmpResponse_service {


    private long empId;

    private String empName;

    private String empMail;

    private String empDept;

//    private long addId;
//
//    private String areaName;
//
//    private String cityName;
//
//    private String pinCode;
}
