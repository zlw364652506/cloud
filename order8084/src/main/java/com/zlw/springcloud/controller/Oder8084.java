package com.zlw.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController

public class Oder8084 {
    @Resource
    public RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    public String url;
    @GetMapping(value = "consumer/payment/getport/{id}")
    public String GetPort(@PathVariable("id") String id){
        return restTemplate.getForObject(url+"/payment/getport/"+id,String.class);
    }
}
