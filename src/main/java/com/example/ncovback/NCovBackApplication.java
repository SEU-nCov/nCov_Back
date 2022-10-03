package com.example.ncovback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ncovback.mapper")
public class NCovBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(NCovBackApplication.class, args);
    }

}
