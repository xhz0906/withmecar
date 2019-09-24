package hi.cc.service.impl;

import com.github.pagehelper.PageHelper;
import hi.car.pojo.CarManufacturer;
import hi.cc.mapper.CarManufacturerMapper;
import hi.cc.service.CarManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarManufacturerServiceImpl implements CarManufacturerService {
    @Resource
    private CarManufacturerMapper carManufacturerMapper;
    /**
     * 查询厂商
     * @return
     */
    @Override
    public List<CarManufacturer> findManufacturer(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<CarManufacturer> manufacturer = carManufacturerMapper.findManufacturer();

        return manufacturer;
    }

    @Override
    public int getMaxPage(int rows) {
        int count=carManufacturerMapper.getMaxCount();
        return count%rows==0?count/rows:count/rows+1;
    }
    /**
     * 查询厂商
     * @return
     */
    @Override
    public List<CarManufacturer> findManufacturer1(String name,int page, int rows) {
        PageHelper.startPage(page,rows);
        List<CarManufacturer> manufacturer = carManufacturerMapper.findManufacturer1(name);
        return manufacturer;
    }

    @Override
    public int getMaxPage1(String name,int rows) {
        int count=carManufacturerMapper.getMaxCount1(name);
        return count%rows==0?count/rows:count/rows+1;
    }

    @Override
    public List<String> findManufacturer01(String brandName) {
        List<String> manufacturer01 = carManufacturerMapper.findManufacturer01(brandName);
        return manufacturer01;
    }

    /**
     * 查brandname
     * @return
     */
    public List<String> findBrandByM(){
        List<String> brandByM = carManufacturerMapper.findBrandByM();
        return brandByM;
    }
    @Override
    public boolean saveCarManufacturer(String name,String brandName,String createTime) {
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("brandName",brandName);
        map.put("createTime",createTime);
        System.out.println("map = " + map);
        boolean b = carManufacturerMapper.saveCarManufacturer(map);
        return b;
    }

    @Override
    public boolean deleteCarManufacturer(int id) {
        boolean deleteCarCarManufacturer= carManufacturerMapper.deleteCarManufacturer(id);
        return deleteCarCarManufacturer;
    }

    @Override
    public CarManufacturer findCarManufacturer(int id) {
        CarManufacturer carManufacturer = carManufacturerMapper.findCarManufacturer(id);
        return carManufacturer;
    }

    @Override
    public boolean updateCarManufacturer(int id,String name,String brandName,String updateTime) {
        Map<Object,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("brandName",brandName);
        map.put("updateTime",updateTime);
        System.out.println("map = " + map);
        boolean b = carManufacturerMapper.updateCarManufacturer(map);
        return b;
    }

    @Override
    public boolean updateId(int brandId, String brandName) {
        Map<Object,Object> map = new HashMap<>();
        map.put("brandId",brandId);
        map.put("brandName",brandName);
        carManufacturerMapper.updateId(map);
        return false;
    }

    @Override
    public List<String> findManufacturerName() {
        List<String> manufacturerName = carManufacturerMapper.findManufacturerName();
        return manufacturerName;
    }
}
