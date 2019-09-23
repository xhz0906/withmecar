package hi.cc.mapper;

import hi.car.pojo.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityMapper_xpy {
    /**
     * 根据类型查询
     * @param type
     * @return
     */
    public List<City> findByType(int type);

    /**
     * 根据pid查询
     * @param pid
     * @return
     */
    public List<City> findByPid(int pid);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    public City findIdByName(String name);
}
