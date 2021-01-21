package com.zlw.springcloud.service;

import com.zlw.springcloud.entities.Parment;
import org.apache.ibatis.annotations.Param;

public interface ParmentService {
    public  int  Creat(Parment parment);

    public  Parment GetParmentByid(@Param("id") String id);
}
