package com.zlw.springcloud.controller;

import com.zlw.springcloud.entities.CommonResult;
import com.zlw.springcloud.entities.Parment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.zlw.springcloud.service.PaymentFeign;

import javax.annotation.Resource;

@RestController
public class FeiginController {
    @Resource
    PaymentFeign paymentFeign;
    @GetMapping(value ="/consumer/feign/{tid}")
    public CommonResult GetParment(@PathVariable("tid") String tid){
        System.out.println("111");
        return paymentFeign.GetParment(tid);
    }
    @GetMapping(value ="/consumer/feign/creat")
    public CommonResult Creat(Parment parment){
        return paymentFeign.Creat(parment);
    }
    @GetMapping(value ="/consumer/feignout")
    public String getFeignOut(){
        return  paymentFeign.FeignOutTime();
    }
    @GetMapping(value ="/consumer/hystrix/{id}")
    public String  paymentInfo_Outtime(@PathVariable("id") Integer id){
    return  paymentFeign.paymentInfo_Outtime(id);
    }

}
