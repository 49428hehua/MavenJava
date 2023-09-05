package com.example.mavenjava.mybatiscatalog.jpa.redis;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@RedisHash("persons")
public class Person {
    @Id
    private String id;
    @Indexed
    private String firstname;
    @Indexed
    private String lastname;

}
