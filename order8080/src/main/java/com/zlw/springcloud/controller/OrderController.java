package com.zlw.springcloud.controller;

import com.zlw.springcloud.entities.CommonResult;
import com.zlw.springcloud.entities.Parment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.reflect.Parameter;

@RestController
public class OrderController {

    @Resource
    RestTemplate restTemplate;
    public  static  final  String url ="http://PAYMENT";
   // public  static  final  String url ="http://localhost:8081";
    @GetMapping(value = "/consumer/payment/creat")
    public CommonResult<Parameter> creat(Parment parment){
        return  restTemplate.postForObject(url+"/payment/create",parment,CommonResult.class);
    }
    @GetMapping(value = "/consumer/payment/get/{tid}")
    public CommonResult<Parment> getParment(@PathVariable("tid") String tid){
        return restTemplate.getForObject(url+"/payment/get/"+tid,CommonResult.class);
    }
}
