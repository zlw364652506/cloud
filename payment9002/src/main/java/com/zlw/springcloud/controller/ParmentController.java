package com.zlw.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class ParmentController {

    @Value("${server.port}")
    private String port;
    @GetMapping(value = "/payment/getport/{id}")
    public  String  getPort(@PathVariable("id") String id){
        return port+id;
    }
}
