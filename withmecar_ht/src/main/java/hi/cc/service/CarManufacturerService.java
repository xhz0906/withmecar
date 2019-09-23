package hi.cc.service;

import hi.car.pojo.CarManufacturer;

import java.util.List;
import java.util.Map;

public interface CarManufacturerService {
    /**
     * 查询厂商
     * @return
     */
    public List<CarManufacturer> findManufacturer(int page,int rows);
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
    public boolean saveCarManufacturer(String name,String brandName,String createTime);
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
    public boolean updateCarManufacturer(int id,String name,String brandName,String updateTime);
    /**
     * 修改brandId
     * @param map
     * @return
     */
    public boolean updateId(int brandId,String brandName);
    /**
     *
     * 查出厂商名
     * @return
     */
    public List<String> findManufacturerName();
}
