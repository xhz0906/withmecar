package hi.cc.mapper;

import hi.car.pojo.CarParam;
import hi.car.pojo.CarParamType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CarParamMapper {
    /**
     * 查询车型参数
     * @return
     */
    public List<CarParam> findParam();
    /**
     * 查询总个数
     * @return
     */
    public int getMaxCount();
    /**
     * 根据id查出要修改的
     * @param id
     * @return
     */
    public CarParam findCarParam(int id);

    /**
     * 修改
     * @param map
     * @return
     */
    public boolean updateCarParam(Map<String,Object> map);
}
