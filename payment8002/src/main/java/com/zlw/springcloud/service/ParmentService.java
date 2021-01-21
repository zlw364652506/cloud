package com.zlw.springcloud.service;

import com.zlw.springcloud.entities.Parment;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface ParmentService {
    public  int  Creat(Parment parment);
    public  Parment GetParmentByid(@Param("tid") String tid);
}
