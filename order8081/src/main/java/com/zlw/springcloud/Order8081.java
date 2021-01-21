package com.zlw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Order8081 {
    public static  void main(String[] args){
        SpringApplication.run(Order8081.class,args);
    }
}
