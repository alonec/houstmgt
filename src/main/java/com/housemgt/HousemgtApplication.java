package com.housemgt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.housemgt.mapper")
public class HousemgtApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousemgtApplication.class, args);
    }

}
