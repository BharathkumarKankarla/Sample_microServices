package com.employee_service.Empservice;

import com.employee_service.DtoClasses.EmpResponse_service;
import com.employee_service.DtoClasses.EmpService_DTO;
import com.employee_service.EmployeeRepo.EmpRepository;
import com.employee_service.FeignClients.EmployeeAddress_client;
import com.employee_service.entity.EmpAddress_entity;
import com.employee_service.entity.EmpClass_entity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class EmpService {

    @Autowired
    private EmpRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeAddress_client addressClient;

    private EmpService service;

    public EmpResponse_service postDetails(EmpClass_entity entity) {
        EmpClass_entity emp = repo.save(entity);
        EmpResponse_service empResponseService = new EmpResponse_service();
        modelMapper.map(emp, EmpResponse_service.class);
        return empResponseService;
    }

    public List<EmpResponse_service> getAllempDetails() {

        List<EmpResponse_service> empResponseServices = new ArrayList<>();
        List<EmpClass_entity> entities = repo.findAll();

        List<EmpAddress_entity> addressDetails = addressClient.getAllAddressDetails();

        //List<EmpService_DTO> emp = new ArrayList<>();

        EmpService_DTO emp=new EmpService_DTO();


        for (EmpClass_entity entity : entities) {
            empResponseServices.add(modelMapper.map(entity, EmpResponse_service.class));
        }

//        EmpResponse_service emp = new EmpResponse_service();
//
//        empResponseServices = this.modelMapper.map(addressDetails);

//        for (EmpClass_entity employee : entities){
//            for (EmpAddress_entity empAddressEntity : addressDetails ){
//                emp.add(employee)
//            }
//        }



        return empResponseServices;
    }

    public EmpResponse_service getDetailsByid(long empId) {
        EmpClass_entity ent = repo.findByEmpId(empId);
       // EmpResponse_service empResponseService = new EmpResponse_service();
        EmpResponse_service response = this.modelMapper.map(ent, EmpResponse_service.class);
        return response;
    }

    public String getNameById(long empId) {

       // EmpAddress_entity city = addressClient.getCityById(empId);
        return repo.findNameByEmpId(empId);
    }

//    public ResponseEntity<List<EmpResponse_service>> getAddressandEmpAllDetails() {
//        List<EmpClass_entity> empdetails = repo.findAll();
//        List<EmpAddress_entity> addressDetails = addressClient.getAllAddressDetails();
//
//        List<EmpResponse_service> getAllDetails = new ArrayList<>();
//
//        for (EmpClass_entity empDetails: empdetails
//             ) {
//            getAllDetails.add(modelMapper.map(empDetails, EmpResponse_service.class));
//        }
//
//        for (EmpAddress_entity addressdetails: addressDetails
//             ) {
//            getAllDetails.add(modelMapper.map(addressdetails, EmpResponse_service.class));
//        }
//
//        return ResponseEntity.ok(getAllDetails);
//    }
}
