package com.qf.j1904.service.impl;

import com.qf.j1904.mapper.MemCarMapper_xpy;
import com.qf.j1904.service.MemCarService_xpy;
import hi.car.pojo.MemberCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemCarServiceImpl_xpy implements MemCarService_xpy {
    @Autowired
    private MemCarMapper_xpy memCarMapper;

    @Override
    public boolean updateMemCar(MemberCar mcar) {
        int c = memCarMapper.updateMemCar(mcar);
        return c>0?true:false;
    }

    @Override
    public MemberCar findMemCar(int id) {
        return memCarMapper.findMemCar(id);
    }

    @Override
    public MemberCar findMemCarById(int id,int type) {
        Map<String,Integer> map = new HashMap<>();
        map.put("id",id);
        map.put("type",type);
        return memCarMapper.findMemCarById(map);
    }

    @Override
    public boolean saveMemCar(MemberCar memcar) {
        int c = memCarMapper.saveMemCar(memcar);
        return c>0?true:false;
    }

    @Override
    public boolean deleteById(int id) {
        int c = memCarMapper.deleteById(id);
        return c>0?true:false;
    }
}
