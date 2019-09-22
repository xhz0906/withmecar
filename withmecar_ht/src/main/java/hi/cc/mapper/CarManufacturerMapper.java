package hi.cc.mapper;

import hi.car.pojo.CarBrand;
import hi.car.pojo.CarManufacturer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CarManufacturerMapper {
    /**
     * 查询厂商
     * @return
     */
    public List<CarManufacturer> findManufacturer();
    /**
     * 查询汽车厂商总个数
     * @return
     */
    public int getMaxCount();
    /**
     * 增加
     * @return
     */
    public boolean saveCarManufacturer(Map<String,String> map);
    /**
     *删除
     * @return
     */
    public boolean deleteCarManufacturer(int id);

    /**
     * 根据id查出要修改的
     * @param id
     * @return
     */
    public CarManufacturer findCarManufacturer(int id);
    /**
     * 修改
     * @return
     */
    public boolean updateCarManufacturer(Map<Object,Object> map);

    /**
     * 修改brandId
     * @param map
     * @return
     */
    public boolean updateId(Map<Object,Object> map);
    /**
     *
     * 查出厂商名
     * @return
     */
    public List<String> findManufacturerName();
}
