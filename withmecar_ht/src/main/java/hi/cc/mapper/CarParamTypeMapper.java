package hi.cc.mapper;

import hi.car.pojo.CarModel;
import hi.car.pojo.CarParamType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CarParamTypeMapper {
    /*
    查询参数分类
     */
    public List<CarParamType> findParamType();
    /**
     * 查询总个数
     * @return
     */
    public int getMaxCount();

    /**
     * 增加
     * @return
     */
    public boolean saveCarParamType(Map<String,String> map);
    /**
     * 根据id查出要修改的
     * @param id
     * @return
     */
    public CarParamType findCarParamType(int id);

    /**
     * 修改
     * @param map
     * @return
     */
    public boolean updateCarParamType(Map<String,Object> map);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean deleteCarParamType(int id);
}
