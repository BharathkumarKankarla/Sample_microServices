package com.SpringJPA.controller;

import com.SpringJPA.Address_Entity.EmpAddress_entity;
import com.SpringJPA.address_service.EmpAddress_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp_address")
public class EmpAddress_Controller {

    @Autowired
    private EmpAddress_service service;

    @PostMapping("/")
    public ResponseEntity<EmpAddress_entity> postDetails(@RequestBody EmpAddress_entity entity){
        EmpAddress_entity ent = service.postDetails(entity);
        return ResponseEntity.ok(ent);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmpAddress_entity>> getAllDetails(){
        List<EmpAddress_entity> ent = service.getAllDetails();
        return ResponseEntity.ok(ent);
    }

    @GetMapping("/{addId}")
    public ResponseEntity<Optional<EmpAddress_entity>> getAddressById(@PathVariable("addId") long addId){
        Optional<EmpAddress_entity> ent = service.getAddressById(addId);
        return ResponseEntity.ok(ent);
    }

    @GetMapping("/city/{addId}")
    public ResponseEntity<String> getCityByid(@PathVariable("addId") long addId){
        String getCity = service.getCityByaddressId(addId);
        return ResponseEntity.ok(getCity);
    }
}
