package com.qf.j1904.service.impl;

import com.qf.j1904.mapper.ActivityMapper_xpy;
import com.qf.j1904.service.ActivityService_xpy;
import hi.car.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl_xpy implements ActivityService_xpy {
    @Autowired
    private ActivityMapper_xpy activityMapper;
    @Override
    public List<Activity> findAll() {
        return activityMapper.findAll();
    }

    @Override
    public Activity findById(int id) {
        return activityMapper.findById(id);
    }
}
