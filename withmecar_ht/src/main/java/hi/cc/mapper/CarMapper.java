package hi.cc.mapper;

import hi.car.pojo.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CarMapper {
    /**
     * 查询所有车款
     * @return
     */
    public List<Car> findCar();
    /**
     * 查询汽车车款总个数
     * @return
     */
    public int getMaxCount();

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
    public boolean saveCar(Map<String,String> map);
    /**
     * 修改brandId
     * @param map
     * @return
     */
    public boolean updateId(Map<Object,Object> map);

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
    public boolean saveCarYear(Map<String,Object> map);
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
    public boolean updateCar(Map<String,Object> map);

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
    public boolean updateCarYear(Map<String,Object> map);

    /**
     * 修改配置
     * @param map
     * @return
     */
    public boolean updateConfig(Map<String,Object> map);

}
