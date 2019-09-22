package hi.cc.mapper;

import hi.car.pojo.CarManufacturer;
import hi.car.pojo.CarModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CarModelMapper {
    /**
     * 查询车系
     * @return
     */
    public List<CarModel> findCarModel();
    /**
     * 查询车系
     * @return
     */
    public List<String> findModel1();
    /**
     * 查询汽车车系总个数
     * @return
     */
    public int getMaxCount();

    /**
     * 添加车系
     * @param map
     * @return
     */
    public boolean saveCarModel(Map<String,String> map);
    /**
     *删除
     * @return
     */
    public boolean deleteCarModel(int id);

    /**
     * 根据id查出要修改的
     * @param id
     * @return
     */
    public CarModel findModel(int id);
    /**
     * 修改
     * @return
     */
    public boolean updateModel(Map<Object,Object> map);
    /**
     * 查出所有类型
     */
    public List<String> findType();
    /**
     * 修改品牌id
     */
    public boolean updateId(Map<Object,Object> map);

}
