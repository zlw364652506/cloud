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
    public  static  final  String url ="http://payment";
    @GetMapping(value = "/consumer/parment/creat")
    public CommonResult<Parameter> creat(Parment parment){
        return  restTemplate.postForObject(url+"/parment/create",parment,CommonResult.class);
    }
    @GetMapping(value = "/consumer/parment/get/{tid}")
    public CommonResult<Parment> getParment(@PathVariable("tid") String tid){
        return restTemplate.getForObject(url+"/parment/get/"+tid,CommonResult.class);
    }
    @GetMapping(value = "/consumer/parment/zk")
    public  String  getZk(){
        return restTemplate.getForObject(url+"/parment/zk",String.class);
    }
}
