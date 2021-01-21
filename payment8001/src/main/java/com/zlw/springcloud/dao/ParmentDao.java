package com.zlw.springcloud.dao;

import com.zlw.springcloud.entities.Parment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ParmentDao {
    public  int  Creat(Parment parment);

    public  Parment GetParmentByid(@Param("tid") String tid);
}