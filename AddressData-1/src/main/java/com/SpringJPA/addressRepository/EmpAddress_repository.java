package com.SpringJPA.addressRepository;

import com.SpringJPA.Address_Entity.EmpAddress_entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmpAddress_repository extends MongoRepository<EmpAddress_entity, Long> {

    @Query(value = "{ 'addId': ?0 }", fields = "{ 'cityName': 1 }")
    String getCityNameByAddId(long addId);
}
