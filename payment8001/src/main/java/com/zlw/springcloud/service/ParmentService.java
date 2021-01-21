package com.zlw.springcloud.service;

import com.zlw.springcloud.entities.Parment;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface ParmentService {
    public  int  Creat(Parment parment);

    public  Parment GetParmentByid(String tid);

    public String  paymentInfo_Ok(Integer id);

    public String  paymentInfo_Outtime(Integer id) throws InterruptedException;

    public String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
