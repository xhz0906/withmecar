package hi.cc.service;

import hi.car.pojo.CarModel;

import java.util.List;
import java.util.Map;

public interface CarModelService {
    /**
     * 查询车系
     * @return
     */
    public List<CarModel> findCarModel(int page,int rows);
    /**
     * 得出最大页
     * @param rows
     * @return
     */
    public int getMaxPage(int rows);

    /**
     * 添加车系
     * @param map
     * @return
     */
    public boolean saveCarModel(String name,String brandName,String levelName,String createTime);
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
    public boolean updateModel(int id,String name,String brandName,String levelName,String updateTime);
    /**
     * 查出所有类型
     */
    public List<String> findType();
    /**
     * 修改品牌id
     */
    public boolean updateId(int brandId,String brandName);
}
