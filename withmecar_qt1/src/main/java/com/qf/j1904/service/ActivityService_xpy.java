package com.qf.j1904.service;

import hi.car.pojo.Activity;

import java.util.List;

public interface ActivityService_xpy {
    /**
     * 查询所有活动信息
     * @return
     */
    public List<Activity> findAll();
    /**
     * 根据活动id查询活动
     * @param id
     * @return
     */
    public Activity findById(int id);
}
