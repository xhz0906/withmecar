package hi.car.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarModel {
    private int id;//    id	id	int
    private int brandId;//    主品牌ID	brand_id	int
    private String brandName;//    主品牌名称	brand_name	varchar(500)
    private String makeName;//    品牌名称	make_name	varchar(500)
    private String name;//    车系名称	name	varchar(500)
    private String displayName;//    车系显示名称	display_name	varchar(500)
    private String otherName;//    车系其他名称	other_name	varchar(500)
    private String englishName;//    车系英文名称	english_name	varchar(500)
    private String countryClass;//    国别ID	country_class	int
    private String countryClassName;//    国别名称	country_class_name	varchar(500)
    private int bodyForm;//    汽车形态	body_form	int
    private String bodyFormName;//    汽车形态名称	body_form_name	varchar(500)
    private BigDecimal priceLow;//    最低价	price_low	decimal(18,3)
    private BigDecimal PriceHigh;//    最高价	price_high	decimal(18,3)
    private int level;//    车型级别	level	int
    private String levelName;//    车型级别名称	level_name	varchar(500)
    private int levelSecond;//    2级车型级别	level_second	int
    private String levelSecondName;//    车型2级Level名称	level_second_name	varchar(500)
    private int saleStatus;//    销售状态	sale_status	tinyint
    private String allSpell;//    车型名称全拼	all_spell	varchar(50)
    private int countryId;//    所属国家	country_id	int
    private String countryName;//    所属国家名称	country_name	varchar(500)
    private int createTime;//    创建时间	create_time	int(11)
    private int updateTime;//    最后更新时间	update_time	int(11)
    private int syncTime;//    同步时间	sync_time	int(11)


}
