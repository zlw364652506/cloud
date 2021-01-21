package com.zlw.springcloud.controller;

import com.zlw.springcloud.entities.CommonResult;
import com.zlw.springcloud.entities.Parment;
import com.zlw.springcloud.service.ParmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class ParmentController {

    @Resource
    private ParmentService parmentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult Creat(@RequestBody Parment parment) {

        int result = parmentService.Creat(parment);
        CommonResult commonResult = new CommonResult();
        if (result > 0) {
            System.out.println(result);

            commonResult.setCode(200);
            commonResult.setMessage("成功");
        } else {
            commonResult.setCode(400);
            commonResult.setMessage("失败");
        }
         return commonResult;
    }
    @GetMapping(value = "/payment/get/{tid}")
    public CommonResult GetParment(@PathVariable("tid") String tid){
        CommonResult commonResult = new CommonResult();
        Parment parment = parmentService.GetParmentByid(tid);
        commonResult.setCode(200);
        commonResult.setMessage("成功"+port);
        commonResult.setData(parment);
        return commonResult;
    }
    @GetMapping("/payment/disc")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String str :services){
            System.out.println("服务---"+str);
        }

        List<ServiceInstance> instance=discoveryClient.getInstances("PAYMENT");
        for (ServiceInstance serviceInstance : instance){
            System.out.println(serviceInstance.getPort()+"----"+serviceInstance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping("/payment/feignout")
    public String FeignOutTime() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return port;
    }
    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo(@PathVariable("id") Integer id)  {
     String result =parmentService.paymentInfo_Ok(id);
        return result;
    }

    @GetMapping("/payment/hystrix/out/{id}")
    public String PaymentInfoOut(@PathVariable("id") Integer id) throws InterruptedException {
        String result =parmentService.paymentInfo_Outtime(id);
        return result;
    }
    @GetMapping("/payment/hystrix/{id}")
    public  String  PaymentHystrix(@PathVariable("id") Integer id){
        String  result =parmentService.paymentCircuitBreaker(id);
        return  result;
    }
    @GetMapping("/payment/lb")
    public String getPort(){
        return port;
    }
}
