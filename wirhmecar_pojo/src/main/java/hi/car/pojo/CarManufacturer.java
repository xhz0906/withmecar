package hi.car.pojo;

import lombok.Data;

@Data
public class CarManufacturer {
    private int id;//厂商id
    private int brandId;//品牌id
    private String brandName;//品牌名称
    private String name;//厂商名称
    private String createTime;//创建时间
    private String updateTime;//修改时间

    private CarBrand carBrand=new CarBrand();
}
