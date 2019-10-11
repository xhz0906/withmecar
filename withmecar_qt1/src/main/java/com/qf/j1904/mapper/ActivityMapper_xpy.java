package com.qf.j1904.mapper;

import hi.car.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper_xpy {
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
