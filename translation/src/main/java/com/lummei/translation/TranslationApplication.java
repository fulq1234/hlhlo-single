package com.lummei.translation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TranslationApplication {

    public static void main(String[] args) {
        //ClassScaner.scan("com.lummei.jobapp.protocol", null);
        SpringApplication.run(TranslationApplication.class, args);
    }
}
