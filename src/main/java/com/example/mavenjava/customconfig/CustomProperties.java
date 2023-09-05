package com.example.mavenjava.customconfig;

import com.example.mavenjava.configbean.Course;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@Configuration
@PropertySource("classpath:custom.properties")
@EnableConfigurationProperties(CustomProperties.class)
@ConfigurationProperties(prefix ="")
public class CustomProperties {
    private int id;
    private String name;
    private int age;
    private String[] hobby;//爱好
    private List electProduct;//电子产品
    private Map friends;//朋友
    private Course course;//课程

}
