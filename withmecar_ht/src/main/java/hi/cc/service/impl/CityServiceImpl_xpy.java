package hi.cc.service.impl;

import hi.car.pojo.City;
import hi.cc.mapper.CityMapper_xpy;
import hi.cc.service.CityService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl_xpy implements CityService_xpy {
    @Autowired
    private CityMapper_xpy cityMapper;
    @Override
    public List<City> findByType(int type) {
        return cityMapper.findByType(type);
    }

    @Override
    public List<City> findByPid(int pid) {
        return cityMapper.findByPid(pid);
    }

    @Override
    public City findIdByName(String name) {
        return cityMapper.findIdByName(name);
    }
}
