package com.zlw.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zlw.springcloud.dao.ParmentDao;
import com.zlw.springcloud.entities.Parment;
import com.zlw.springcloud.service.ParmentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class ParmentServiceImpl implements ParmentService {
    @Resource
    ParmentDao parmentDao;
    @Override
    public int Creat(Parment parment) {
        return parmentDao.Creat(parment);
    }

    @Override
    public Parment GetParmentByid(String tid) {
        return parmentDao.GetParmentByid(tid);
    }

    public String  paymentInfo_Ok(Integer id){
        return "线程池"+Thread.currentThread().getName()+"OK,Id="+id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_Handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String  paymentInfo_Outtime(Integer id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        //int age = 10/0;
        return "线程池"+Thread.currentThread().getName()+"OutTime,Id="+id;
    }
    @HystrixCommand(fallbackMethod = "paymentInfo_Handler",
    commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //开启熔断
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间段
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), // 错误率

    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw  new RuntimeException("id不能为负数");
        }
        String number = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"调用成功"+number;
    }

    public String  paymentInfo_Handler(Integer id){
        return "服务繁忙"+id;
    }

}
