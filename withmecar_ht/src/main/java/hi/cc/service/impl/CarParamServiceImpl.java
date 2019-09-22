package hi.cc.service.impl;

import com.github.pagehelper.PageHelper;
import hi.car.pojo.CarParam;
import hi.car.pojo.CarParamType;
import hi.cc.mapper.CarParamMapper;
import hi.cc.service.CarParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class CarParamServiceImpl implements CarParamService{
    @Resource
    private CarParamMapper carParamMapper;

    @Override
    public List<CarParam> findParam(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<CarParam> paramType = carParamMapper.findParam();
        return paramType;
    }

    @Override
    public int getMaxPage(int rows) {
        int count=carParamMapper.getMaxCount();
        return count%rows==0?count/rows:count/rows+1;
    }

    @Override
    public CarParam findCarParam(int id) {
        CarParam carParam = carParamMapper.findCarParam(id);
        return carParam;
    }

    @Override
    public boolean updateCarParam(int id, String name,String type,String state) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("state",state);
        boolean b = carParamMapper.updateCarParam(map);
        return b;
    }
}
