package com.lrk.o2o;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@ImportResource(locations = {"classpath:kaptcha.xml"})
@MapperScan("com.lrk.o2o.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class O2oApplication {

    public static void main(String[] args) {
        SpringApplication.run(O2oApplication.class, args);
    }

}
