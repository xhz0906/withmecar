package hi.cc.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
//品牌分值字典表
public class DictBrandPoint implements Serializable {
    private int id;//	id	int
    private int brandId;//主品牌ID	brand_id	int	关联car_brand表的ID字段
    private String name;//主品牌名称	name	varchar(100)
    private int point;//初始分值	point	tinyint
}
