package hi.cc.service;

import hi.car.pojo.CarModel;
import hi.car.pojo.CarParamType;

import java.util.List;
import java.util.Map;

public interface CarParamTypeService {
    /*
    查询参数分类
     */
    public List<CarParamType> findParamType(int page, int rows);
    /**
     * 得出最大页
     * @param rows
     * @return
     */
    public int getMaxPage(int rows);
    /**
     * 增加
     * @return
     */
    public boolean saveCarParamType(String name,String state);
    /**
     * 根据id查出要修改的
     * @param id
     * @return
     */
    public CarParamType findCarParamType(int id);

    /**
     * 修改
     * @param name
     * @param state
     * @return
     */
    public boolean updateCarParamType(int id,String name,String state);
    /**
     * 删除
     * @param id
     * @return
     */
    public boolean deleteCarParamType(int id);
}
