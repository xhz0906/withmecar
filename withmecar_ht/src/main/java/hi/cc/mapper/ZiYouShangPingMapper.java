package hi.cc.mapper;


import hi.car.pojo.CarLogo;
import hi.car.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ZiYouShangPingMapper {
    public List<Product>findAllProduct();
//    后台信息显示
    public int ap(Product product);
//    添加信息
    public int dp(int id);
//    根据id删除
    public CarLogo fci(@Param("id") int id);
//    跟据carlogo表的id查询
    public Product fpi(@Param("id") int id);
//    根据product表的id查询
    public int totaCount();

}
