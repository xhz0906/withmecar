package hi.cc.service;

import hi.car.pojo.Car;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CarService {
    /**
     * 查询所有车款
     * @return
     */
    public List<Car> findCar(int page,int rows);
    /**
     * 得出最大页
     * @param rows
     * @return
     */
    public int getMaxPage(int rows);
    /**
     * 查询所有车款
     * @return
     */
    public List<Car> findCar11(String name,int page,int rows);
    /**
     * 得出最大页
     * @param rows
     * @return
     */
    public int getMaxPage1(String brandName,int rows);
    /**
     * 通过车型id查年款
     * @param modelId
     * @return
     */
    public List<String> getYearById(int id);
    /**
     * 添加车款
     * @param map
     * @return
     */
    public boolean saveCar(String name,String brandName,String makeName,String levelName,String createTime);
    /**
     * 修改品牌id
     */
    public boolean updateId(int brandId,String brandName);
    /**
     * 查车系
     * @return
     */
    public List<String> findMake();

    /**
     *查年款
     * @return
     */
    public List<String> findYear();
    /**
     * 添加指定年款
     * @param map
     * @return
     */
    public boolean saveCarYear(int id,String year);
    /**
     * 查指定id
     */
    public List<Integer> findCarId();

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean deleteCar(int id);
    public boolean deleteCarYear(int id);
    /**
     * 通过id查指定属性
     *
     */
    public Car findCar1(int id);
    /**
     * 修改
     * @return
     */
    public boolean updateCar(int id,String name,String brandName,String makeName,String levelName,String updateTime);
    /**
     * 通过id查出所有参数
     * @param id
     * @return
     */
    public Car findConfig(int id);
    /**
     * 添加指定年款
     * @param map
     * @return
     */
    public boolean updateCarYear(int id,String year);
    /**
     * 修改配置
     * @param map
     * @return
     */
    public boolean updateConfig(int id, String allSpell, String countryClassName, String bodyFormName, BigDecimal priceLow, BigDecimal priceHigh, String countryName, String updateName);
}
