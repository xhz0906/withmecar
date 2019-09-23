package hi.cc.service;

import hi.car.pojo.CarBrand;

import java.util.List;

public interface CarBrandService {
    /**
     *查询车品牌
     * @return
     */
    public List<CarBrand> findCarBrand(int page,int rows);

    /**
     * 增加
     * @return
     */
    public boolean saveCarBrand(String name,String logo,String createTime);

    /**
     *删除
     * @return
     */
    public boolean deleteCarBrand(int id);
    /**
     * 根据id查出要修改的
     * @param id
     * @return
     */
    public CarBrand findBrand(int id);
    /**
     * 修改
     * @return
     */
    public boolean updateCarBrand(int id,String name,String logo,String updateTime);
    //通过id查询数据
    public CarBrand getCarBrandById(int brand_id);
    /**
     * 查出所有的品牌名
     * @return
     */
    public List<String> findBrand1();
    /**
     * 通过name查id
     * @param name
     * @return
     */
    public int saveId(String brandName);

    /**
     * 查询品牌logo
     * @return
     */
    public List<String> findBrandLogo();
    /**
     * 通过logo查品牌名
     * @return
     */
    public String findBrandName(String brandLogo);
    /**
     * 判断brandlogo和brandname是否存在
     * @param brandName
     * @param brandLogo
     * @return
     */
    public int findBrandName1(String brandName,String brandLogo);
    /**
     * 通过logo查品牌名
     * @return
     */
    public String findBrandName2(String brandLogo);

    /**
     * 得出最大页
     * @param rows
     * @return
     */
    public int getMaxPage(int rows);
}

