package com.easyjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.easyjob"})
public class EasyjobApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyjobApiApplication.class,args);
    }
}
