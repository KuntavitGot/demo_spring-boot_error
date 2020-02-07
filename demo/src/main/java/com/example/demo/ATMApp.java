package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class ATMApp {
    public static void main(String[] arg){
        SpringApplication.run(ATMApp.class,arg);
    }
}
