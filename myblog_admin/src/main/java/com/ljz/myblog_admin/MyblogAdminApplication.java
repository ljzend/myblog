package com.ljz.myblog_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyblogAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyblogAdminApplication.class, args);
    }

    static {
        System.setProperty("druid.mysql.usePingMethod", "false");
    }
}
