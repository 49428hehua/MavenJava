package com.example.mavenjava.mybatiscatalog.redis;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person,String> {
    List<Person> findByLastname(String lastname);
    Page<Person> findPersonByLastname(String lastname, Pageable page);
    List<Person> findByFirstnameAndLastname(String firstname, String lastname);
    List<Person> findByAddress_City(String city);
    List<Person> findByFamilyList_Username(String username);

}
