package com.lummei.jobapp;

import com.lummei.jobapp.service.ClassScaner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lummei.jobapp.mapper")
public class JobappApplication {

    public static void main(String[] args) {
        ClassScaner.scan("com.lummei.jobapp.protocol", null);
        SpringApplication.run(JobappApplication.class, args);
    }
}
