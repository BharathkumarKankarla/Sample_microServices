package com.SpringJPA.Address_Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("EmployeeAddress_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpAddress_entity {

    @Id
    private long addId;
    @Field("Employee_Area")
    private String areaName;
    @Field("Employee_City")
    private String cityName;
    @Field("Employee_areaPincode")
    private String pinCode;
}
