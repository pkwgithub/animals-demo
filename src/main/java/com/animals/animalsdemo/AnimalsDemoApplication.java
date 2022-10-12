package com.animals.animalsdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:applicationContext.xml")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
//@SpringBootApplication
public class AnimalsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalsDemoApplication.class, args);
    }

}
