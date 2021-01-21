package com.zlw.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.zlw.springcloud.entities.CommonResult;
import com.zlw.springcloud.entities.Parment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "PAYMENT",fallback = PaymentFallFegin.class)
public interface PaymentFeign {

    @GetMapping(value = "/payment/get/{tid}")
    public CommonResult GetParment(@PathVariable("tid") String tid);

    @PostMapping(value = "/payment/create")
    public CommonResult Creat(@RequestBody Parment parment) ;

    @GetMapping("/payment/feignout")
    public String FeignOutTime();

    @GetMapping("/payment/hystrix/ok/{id}")
    public String  paymentInfo_Ok(Integer id);

    @GetMapping("/payment/hystrix/out/{id}")
    public String  paymentInfo_Outtime(Integer id);

}
