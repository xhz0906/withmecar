package hi.cc.mapper;

import hi.car.pojo.CarBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface CarBrandMapper {
    /**
     *查询车品牌
     * @return
     */
    public List<CarBrand> findCarBrand();

    /**
     * 增加
     * @return
     */
    public boolean saveCarBrand(Map<String,String> map);
    /**
     * 查询汽车品牌总个数
     * @return
     */
    public int getMaxCount();
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
    public boolean updateCarBrand(Map<Object,Object> map);
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
     * @return
     */
    public int findBrandName1(HashMap<String, String> map);
    /**
     * 通过logo查品牌名
     * @return
     */
    public String findBrandName2(String brandLogo);
}
