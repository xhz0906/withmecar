package hi.cc.service.impl;

import com.github.pagehelper.PageHelper;
import hi.car.pojo.Car;
import hi.cc.mapper.CarMapper;
import hi.cc.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {
    @Resource
    private CarMapper carMapper;
    @Override
    public List<Car> findCar(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Car> car = carMapper.findCar();
        return car;
    }

    @Override
    public int getMaxPage(int rows) {
        int count=carMapper.getMaxCount();
        return count%rows==0?count/rows:count/rows+1;
    }

    @Override
    public List<String> getYearById(int id) {
        List<String> yearById = carMapper.getYearById(id);
        return yearById;
    }

    @Override
    public boolean saveCar(String name, String brandName, String makeName, String levelName,String createTime) {
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("brandName",brandName);
        map.put("makeName",makeName);
        map.put("levelName",levelName);
        map.put("createTime",createTime);
        System.out.println("map = " + map);
        boolean b = carMapper.saveCar(map);
        return b;
    }

    @Override
    public boolean updateId(int brandId, String brandName) {
        Map<Object,Object> map = new HashMap<>();
        map.put("brandId",brandId);
        map.put("brandName",brandName);
        carMapper.updateId(map);
        return false;
    }

    @Override
    public List<String> findMake() {
        List<String> make = carMapper.findMake();
        return make;
    }

    @Override
    public List<String> findYear() {
        List<String> year = carMapper.findYear();
        return year;
    }

    @Override
    public boolean saveCarYear(int id, String year) {
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("year",year);
        carMapper.saveCarYear(map);
        return false;
    }

    @Override
    public List<Integer> findCarId() {
        List<Integer> id = carMapper.findCarId();
        return id;
    }

    @Override
    public boolean deleteCar(int id) {
        boolean b = carMapper.deleteCar(id);
        return b;
    }

    @Override
    public boolean deleteCarYear(int id) {
        boolean b = carMapper.deleteCarYear(id);
        return b;
    }

    @Override
    public Car findCar1(int id) {
        Car car1 = carMapper.findCar1(id);
        System.out.println("car1 = " + car1);
        return car1;
    }

    @Override
    public boolean updateCar(int id,String name,String brandName,String makeName,String levelName,String updateTime) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("brandName",brandName);
        map.put("makeName",makeName);
        map.put("levelName",levelName);
        map.put("updateTime",updateTime);
        boolean b = carMapper.updateCar(map);
        return b;
    }

    @Override
    public Car findConfig(int id) {
        Car config = carMapper.findConfig(id);
        return config;
    }

    @Override
    public boolean updateCarYear(int id, String year) {
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("year",year);
        carMapper.updateCarYear(map);
        return false;
    }

    @Override
    public boolean updateConfig(int id, String allSpell, String countryClassName, String bodyFormName, BigDecimal priceLow, BigDecimal priceHigh, String countryName, String updateTime) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("allSpell",allSpell);
        map.put("countryClassName",countryClassName);
        map.put("bodyFormName",bodyFormName);
        map.put("priceLow",priceLow);
        map.put("priceHigh",priceHigh);
        map.put("countryName",countryName);
        map.put("updateTime",updateTime);

        boolean b = carMapper.updateConfig(map);
        return b;
    }
}
