package com.employee_service.FeignClients;

import com.employee_service.entity.EmpAddress_entity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "addressClient1", url = "http://localhost:9898/emp_address/")
public interface EmployeeAddress_client {

    @GetMapping("/{empId}")
    public EmpAddress_entity getAddressByEmployeeId(@PathVariable("empId") long empId);

    @GetMapping("/")
    public List<EmpAddress_entity> getAllAddressDetails();

    @GetMapping("/city/{empId}")
    public String getCityById(@PathVariable("empId") long empId);
}
