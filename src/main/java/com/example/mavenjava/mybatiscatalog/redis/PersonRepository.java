package com.example.mavenjava.mybatiscatalog.redis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Personredis,String> {
    List<Personredis> findByLastname(String lastname);
    Page<Personredis> findPersonByLastname(String lastname, Pageable page);
    List<Personredis> findByFirstnameAndLastname(String firstname, String lastname);
    List<Personredis> findByAddress_City(String city);
    List<Personredis> findByFamilyList_Username(String username);
}
