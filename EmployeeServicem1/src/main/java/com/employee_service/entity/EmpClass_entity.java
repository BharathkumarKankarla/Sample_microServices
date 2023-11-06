package com.employee_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("EmployeeDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpClass_entity {

    @Id
    @Field("Employee_Id")
    private long empId;
    @Field("Employee_name")
    private String empName;
    @Field("Employee_Mail")
    private String empMail;
    @Field("Employee_Department")
    private String empDept;
}
