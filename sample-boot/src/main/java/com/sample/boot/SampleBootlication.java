package com.sample.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 * @author laiqiao
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.sample")
public class SampleBootlication {
    public static void main(String[] args) {
        SpringApplication.run(SampleBootlication.class, args);
    }
}
