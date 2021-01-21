package com.zlw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Mian8084 {
    public static  void main(String[] args){
        SpringApplication.run(Mian8084.class,args);
    }
}
