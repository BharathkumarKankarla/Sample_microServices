package com.employee_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpAddress_entity {

    private long addId;
    private String areaName;
    private String cityName;
    private String pinCode;
}
