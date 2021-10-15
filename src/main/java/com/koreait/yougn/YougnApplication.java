package com.koreait.yougn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class YougnApplication {

    public static void main(String[] args) {
        SpringApplication.run(YougnApplication.class, args);
    }

}
