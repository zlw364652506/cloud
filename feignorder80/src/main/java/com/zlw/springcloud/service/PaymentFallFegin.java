package com.zlw.springcloud.service;

import com.zlw.springcloud.entities.CommonResult;
import com.zlw.springcloud.entities.Parment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallFegin implements PaymentFeign {
    @Override
    public CommonResult GetParment(String tid) {
        return null;
    }

    @Override
    public CommonResult Creat(Parment parment) {
        return null;
    }

    @Override
    public String FeignOutTime() {
        return null;
    }

    @Override
    public String paymentInfo_Ok(Integer id) {
        return "FALLBACK---ok";
    }

    @Override
    public String paymentInfo_Outtime(Integer id) {
        return "FALLBACK---OUT";
    }
}
