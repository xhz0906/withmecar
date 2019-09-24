package com.qf.j1904.service.impl;

import com.qf.j1904.mapper.CityMapper_xpy;
import com.qf.j1904.service.CityService_xpy;
import hi.car.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl_xpy implements CityService_xpy {
    @Autowired
    private CityMapper_xpy cityMapper;
    @Override
    public City findCityById(int id) {
        return cityMapper.findCityById(id);
    }
}
