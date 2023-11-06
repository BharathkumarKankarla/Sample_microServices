package com.SpringJPA.address_service;

import com.SpringJPA.Address_Entity.EmpAddress_entity;
import com.SpringJPA.addressRepository.EmpAddress_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpAddress_service {

    @Autowired
    private EmpAddress_repository repo;

    public EmpAddress_entity postDetails(EmpAddress_entity entity) {
        return repo.save(entity);
    }

    public List<EmpAddress_entity> getAllDetails() {
        return repo.findAll();
    }

    public Optional<EmpAddress_entity> getAddressById(long addId) {
        return repo.findById(addId);
    }

    public String getCityByaddressId(long addId) {
        return repo.getCityNameByAddId(addId);
    }
}
