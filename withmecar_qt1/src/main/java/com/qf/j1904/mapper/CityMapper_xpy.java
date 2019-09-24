package com.qf.j1904.mapper;

import hi.car.pojo.City;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityMapper_xpy {
    /**
     * 根据id查询地区信息
     * @param id
     * @return
     */
    public City findCityById(int id);
}
