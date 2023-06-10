package com.example.mavenjava;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MavenJavaApplicationTests {
    @Autowired
    zy1 zy1;
    @Test
    public void contextLoads() {
       String result= zy1.hello();
        System.out.println(result);
    }

}
