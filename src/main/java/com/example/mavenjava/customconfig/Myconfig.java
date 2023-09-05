package com.example.mavenjava.customconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconfig {
    @Bean("Myproperties")
    public Myproperties getMyproperties(){
        return new Myproperties();
    }
}
