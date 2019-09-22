package hi.cc.service.impl;

import com.github.pagehelper.PageHelper;
import hi.car.pojo.Car;
import hi.car.pojo.CarModel;
import hi.car.pojo.CarParamType;
import hi.cc.mapper.CarParamTypeMapper;
import hi.cc.service.CarParamTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarParamTypeServiceImpl implements CarParamTypeService {
    @Resource
    private CarParamTypeMapper carParamTypeMapper;
    @Override
    public List<CarParamType> findParamType(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<CarParamType> paramType = carParamTypeMapper.findParamType();
        return paramType;
    }
    @Override
    public int getMaxPage(int rows) {
        int count=carParamTypeMapper.getMaxCount();
        return count%rows==0?count/rows:count/rows+1;
    }

    @Override
    public boolean saveCarParamType(String name, String state) {
        HashMap<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("state",state);
        boolean b = carParamTypeMapper.saveCarParamType(map);
        return b;
    }

    @Override
    public CarParamType findCarParamType(int id) {
        CarParamType carParamType = carParamTypeMapper.findCarParamType(id);
        return carParamType;
    }

    @Override
    public boolean updateCarParamType(int id,String name, String state) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("state",state);
        carParamTypeMapper.updateCarParamType(map);
        return false;
    }

    @Override
    public boolean deleteCarParamType(int id) {
        boolean b = carParamTypeMapper.deleteCarParamType(id);
        return b;
    }

}
