package com.employee_service.Controller;

import com.employee_service.DtoClasses.EmpResponse_service;
import com.employee_service.DtoClasses.EmpService_DTO;
import com.employee_service.Empservice.EmpService;
import com.employee_service.FeignClients.EmployeeAddress_client;
import com.employee_service.entity.EmpAddress_entity;
import com.employee_service.entity.EmpClass_entity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService service;

   // @Autowired
    //private RestTemplate restTemplate;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EmployeeAddress_client addressClient;

    @PostMapping("/")
    public ResponseEntity<EmpResponse_service> postDetails(@RequestBody EmpClass_entity entity) {
        EmpResponse_service ent = service.postDetails(entity);
        EmpResponse_service ent2 = mapper.map(entity,EmpResponse_service.class);
       // EmpResponse_service ent2 = mapper.map(service.postDetails(entity), EmpResponse_service.class);
        return ResponseEntity.status(HttpStatus.OK).body(ent2);
    }
    @GetMapping("/")
    public ResponseEntity<List<EmpResponse_service>> getAllDetails(){
        List<EmpResponse_service> response = service.getAllempDetails();

        return ResponseEntity.ok(response);
    }

//    @GetMapping("/all-details")
//    public ResponseEntity<List<EmpResponse_service>> getAddressandEmpAllDetails(){
//        return service.getAddressandEmpAllDetails();
//    }
    @GetMapping("/{empId}")
    public ResponseEntity<EmpService_DTO> getDetailsByid(@PathVariable("empId") long empId){
        EmpResponse_service ent = service.getDetailsByid(empId);
        EmpAddress_entity add = addressClient.getAddressByEmployeeId(empId);


        EmpService_DTO dto = new EmpService_DTO();
        dto.setEmployee_address(add);
        dto.setEmployee(ent);
        return ResponseEntity.ok(dto);
    }

//    @GetMapping("/{empId}")
//    public ResponseEntity<List<EmpService_DTO>> getDetailsByid(@PathVariable("empId") long empId){
//
//        return ResponseEntity.ok((List<EmpService_DTO>) service.getAllempDetails());
//    }

    @GetMapping("/Info/{empId}")
    public ResponseEntity<String> getcityandNameByid(@PathVariable("empId") long empId){
        String empName = service.getNameById(empId);
        String address = addressClient.getCityById(empId);
        String empInfo = empName+" "+address;
        return ResponseEntity.ok(empInfo);
    }


}
