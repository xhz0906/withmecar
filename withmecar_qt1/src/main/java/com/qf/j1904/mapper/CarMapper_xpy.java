package com.qf.j1904.mapper;

import hi.car.pojo.Car;
import hi.car.pojo.CarImage;
import hi.car.pojo.CarLogo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CarMapper_xpy {
    /**
     * 修改信息
     * @param car
     * @return
     */
    public int updateCar(@Param("car")Car car);
    /**
     * 添加car
     * @return
     */
    public int addCar(@Param("car") Car car);
    /**
     * 获得最大id
     * @return
     */
    public int findMaxId();
    /**
     * 根据车款车系id查询
     * @param map
     * @return
     */
    public Car findCarByBranMake(int cid);
    /**
     * 查询所有车款图片表
     * @return
     */
    public CarImage findCarImage(int cid);
    /**
     * 查询所有
     * @return
     */
    public List<Car> findAll();

    /**
     * 根据品牌查询所有信息
     * @param bname
     * @return
     */
    public List<Car> findAllByPinpai(String bname);

    /**
     * 根据国家查询所有信息
     * @param cname
     * @return
     */
    public List<Car> findAllByCountry(String cname);

    /**
     * 分页查询
     * @return
     */
    public List<Car> findAllPage();

    /**
     * 根据销售状态排序
     * @return
     */
    public List<Car> findAllByState();

    /**
     * 查询最大页数
     * @return
     */
    public int findCount();

    /**
     * 根据country查询carlogo
     * @param country
     * @return
     */
    public List<CarLogo> findCarLogoByCoun(String country);

    /**
     * 根据品牌查询logo信息
     * @param name
     * @return
     */
    public CarLogo findCarLgByName(String name);

    /**
     * 根据id查询车情
     * @param id
     * @return
     */
    public Car findCarById(int id);

    public List<Car> findAllCar();

    public List<Car> findByTag(String name);

    /**
     * 根据活动id查询参与活动的车辆
     * @param id
     * @return
     */
    public List<Car> findByAct(int id);
}
