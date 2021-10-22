package com.atguigu.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zo2
 */
@SpringBootApplication
@MapperScan(value = "com.atguigu.mybatis.mapper")
public class MybatisPlus01Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus01Application.class, args);
    }

}
