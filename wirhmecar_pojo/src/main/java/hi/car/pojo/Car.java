package hi.car.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Car {
//    id	id	int
//    主品牌ID	brand_id	int
//    主品牌名称	brand_name	varchar(500)
//    品牌ID	make_id	int
//    品牌名称	make_name	varchar(500)
//    车型名称	name	varchar(500)
//    车型显示名称	display_name	varchar(500)
//    车型其他名称	other_name	varchar(500)
//    车型英文名称	english_name	varchar(500)
//    国别ID	country_class	int
//    国别名称	country_class_name	varchar(500)
//    汽车形态	body_form	int
//    汽车形态名称	body_form_name	varchar(500)
//    最低价	price_low	decimal(18,3)
//    最高价	price_high	decimal(18,3)
//    车型级别	level	int
//    车型级别名称	level_name	varchar(500)
//2级车型级别	level_second	int
//    车型2级Level名称	level_second_name	varchar(500)
//    销售状态	sale_status	tinyint
//    车型名称全拼	all_spell	varchar(50)
//    所属国家	country_id	int
//    所属国家名称	country_name	varchar(500)
//    创建时间	create_time	int(11)
//    最后更新时间	update_time	int(11)
//    同步时间	sync_time	int(11)
    private int id;
    private int brandId;
    private String brandName;
    private int makeId;
    private String makeName;
    private String name;
    private String displayName;
    private String otherName;
    private String englishName;
    private int countryClass;
    private String countryClassName;
    private int bodyForm;
    private String bodyFormName;
    private BigDecimal priceLow;
    private BigDecimal priceHigh;
    private int level;
    private String levelName;
    private int levelSecond;
    private String levelSecondName;
    private int saleStatus;
    private String allSpell;
    private int countryId;
    private String countryName;
    private String createTime;
    private String updateTime;
    private String syncTime;
    private CarModelImage carModelImage=new CarModelImage();
    private CarImage carImage=new CarImage();
}
