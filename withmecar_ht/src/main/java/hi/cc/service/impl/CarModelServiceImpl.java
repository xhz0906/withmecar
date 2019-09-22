package hi.cc.service.impl;

import com.github.pagehelper.PageHelper;
import hi.car.pojo.CarModel;
import hi.cc.mapper.CarModelMapper;
import hi.cc.service.CarBrandService;
import hi.cc.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarModelServiceImpl implements CarModelService {
    @Resource
    private CarModelMapper carModelMapper;
    @Override
    public List<CarModel> findCarModel(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<CarModel> carModel = carModelMapper.findCarModel();
        System.out.println("carModel = " + carModel);
        return carModel;
    }

    @Override
    public int getMaxPage(int rows) {
        int count=carModelMapper.getMaxCount();
        return count%rows==0?count/rows:count/rows+1;
    }

    @Override
    public boolean saveCarModel(String name,String brandName,String levelName,String createTime) {
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("brandName",brandName);
        map.put("levelName",levelName);
        map.put("createTime",createTime);
        boolean b = carModelMapper.saveCarModel(map);
        return b;
    }

    @Override
    public boolean deleteCarModel(int id) {
        boolean b = carModelMapper.deleteCarModel(id);
        return b;
    }

    @Override
    public CarModel findModel(int id) {
        CarModel model = carModelMapper.findModel(id);
        return model;
    }

    @Override
    public boolean updateModel(int id,String name,String brandName,String levelName,String updateTime) {
        Map<Object,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("brandName",brandName);
        map.put("levelName",levelName);
        map.put("updateTime",updateTime);
        System.out.println("map = " + map);
        boolean b = carModelMapper.updateModel(map);
        return b;
    }

    @Override
    public List<String> findType() {
        List<String> findtype = carModelMapper.findType();
        return findtype;
    }

    @Override
    public boolean updateId(int brandId, String brandName) {
        Map<Object,Object> map = new HashMap<>();
        map.put("brandId",brandId);
        map.put("brandName",brandName);
        carModelMapper.updateId(map);
        return false;
    }
}
