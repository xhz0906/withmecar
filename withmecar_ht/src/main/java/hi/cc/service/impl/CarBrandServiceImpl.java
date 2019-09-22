package hi.cc.service.impl;

import com.github.pagehelper.PageHelper;
import hi.car.pojo.CarBrand;
import hi.cc.mapper.CarBrandMapper;
import hi.cc.service.CarBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings("unchecked")
@Service
public class CarBrandServiceImpl implements CarBrandService {
    @Resource
    private CarBrandMapper carBrandMapper;
    @Override
    public List<CarBrand> findCarBrand(int page,int rows) {
        PageHelper.startPage(page,rows);
        List<CarBrand> carBrand = carBrandMapper.findCarBrand();
        return carBrand;
    }

    @Override
    public boolean saveCarBrand(String brandName,String brandLogo,String createTime) {
        Map<String,String> map = new HashMap<>();
        map.put("name",brandName);
        map.put("logo",brandLogo);
        map.put("createTime",createTime);
        System.out.println("map = " + map);
        boolean saveCarBrand = carBrandMapper.saveCarBrand(map);
        return saveCarBrand;
    }

    @Override
    public boolean deleteCarBrand(int id) {
        boolean deleteCarBrand = carBrandMapper.deleteCarBrand(id);
        return deleteCarBrand;
    }

    @Override
    public CarBrand findBrand(int id) {
        CarBrand brand = carBrandMapper.findBrand(id);
        return brand;
    }

    @Override
    public boolean updateCarBrand(int id,String name,String logo,String updateTime) {
        Map<Object,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("logo",logo);
        map.put("updateTime",updateTime);
        System.out.println("map = " + map);
        boolean updateCarBrand = carBrandMapper.updateCarBrand(map);
        return updateCarBrand;
    }

    @Override
    public CarBrand getCarBrandById(int brand_id) {
        CarBrand carBrandById = carBrandMapper.getCarBrandById(brand_id);
        return carBrandById;
    }

    @Override
    public List<String> findBrand1() {
        List brand1 = carBrandMapper.findBrand1();
        return brand1;
    }

    @Override
    public int saveId(String brandName) {
        int i = carBrandMapper.saveId(brandName);
        return i;
    }

    @Override
    public List<String> findBrandLogo() {
        List<String> brandLogo = carBrandMapper.findBrandLogo();
        return brandLogo;
    }

    @Override
    public String findBrandName(String brandLogo) {
        String brandName1 = carBrandMapper.findBrandName(brandLogo);
        return brandName1;
    }

    @Override
    public int findBrandName1(String brandName, String brandLogo) {
        HashMap<String, String> map = new HashMap<>();
        map.put("brandLogo",brandLogo);
        map.put("brandName",brandName);
        int brandName1 = carBrandMapper.findBrandName1(map);
        return brandName1;
    }
    @Override
    public String findBrandName2(String brandLogo) {
        String brandName2 = carBrandMapper.findBrandName2(brandLogo);
        System.out.println("brandName2 = " + brandName2);
        return brandName2;
    }

    @Override
    public int getMaxPage(int rows) {
        int count=carBrandMapper.getMaxCount();
        return count%rows==0?count/rows:count/rows+1;
    }

}
