package com.zlw.springcloud.controller;

import com.zlw.springcloud.entities.CommonResult;
import com.zlw.springcloud.entities.Parment;
import com.zlw.springcloud.service.ParmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ParmentController {

    @Resource
    private ParmentService parmentService;

    @Value("${server.port}")
    private String port;

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
    @GetMapping("/payment/lb")
    public String getPort(){
        return port;
    }
}
