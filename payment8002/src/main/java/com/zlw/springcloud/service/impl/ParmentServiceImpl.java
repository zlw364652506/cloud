package com.zlw.springcloud.service.impl;

import com.zlw.springcloud.dao.ParmentDao;
import com.zlw.springcloud.entities.Parment;
import com.zlw.springcloud.service.ParmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
