package com.example.mavenjava.configbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class person {
    @Value("${student.id}")
    private int id;
    @Value("${student.name}")
    private String name;
    @Value("${student.age}")
    private int age;

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
