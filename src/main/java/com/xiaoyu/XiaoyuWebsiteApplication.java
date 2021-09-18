package com.xiaoyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.IOException;

@SpringBootApplication
@MapperScan("com.xiaoyu.dao")
// @ServletComponentScan
public class XiaoyuWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoyuWebsiteApplication.class, args);
        autoOpenProject();
    }

    public static void autoOpenProject() {
        // String cmd = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe http://localhost:8091/index";
        String cmd = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe http://localhost:8091";
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
