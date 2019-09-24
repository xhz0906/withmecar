package hi.cc.service;

import hi.car.pojo.CarParam;
import hi.car.pojo.CarParamType;

import java.util.List;

public interface CarParamService {
    /*
   查询参数分类
    */
    public List<CarParam> findParam(int page, int rows);
    /**
     * 得出最大页
     * @param rows
     * @return
     */
    public int getMaxPage(int rows);
    /*
  查询参数分类
   */
    public List<CarParam> findParam1(String param,int page, int rows);
    /**
     * 得出最大页
     * @param rows
     * @return
     */
    public int getMaxPage1(String param,int rows);
    /**
     * 根据id查出要修改的
     * @param id
     * @return
     */
    public CarParam findCarParam(int id);

    /**
     * 修改
     * @param name
     * @param state
     * @return
     */
    public boolean updateCarParam(int id,String name,String type,String state);


    public List<String> findType001();
}
