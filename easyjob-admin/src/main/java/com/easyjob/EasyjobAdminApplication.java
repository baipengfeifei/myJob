package com.easyjob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.easyjob"})
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
@MapperScan(basePackages = {"com.easyjob.mappers"})
//@ComponentScan(basePackages = {"com.easyjob.entity"})
public class EasyjobAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyjobAdminApplication.class,args);
    }
}
