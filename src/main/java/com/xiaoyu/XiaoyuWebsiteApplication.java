package com.xiaoyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaoyu.dao")
public class XiaoyuWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoyuWebsiteApplication.class, args);
    }

}
