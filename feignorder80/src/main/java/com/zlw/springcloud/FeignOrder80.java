package com.zlw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.zlw.springcloud.service")
@EnableEurekaClient
@EnableHystrix //开启降级服务
public class FeignOrder80 {
    public static  void main(String[] args){
        SpringApplication.run(FeignOrder80.class,args);
    }
}

