package hi.car.pojo;

import lombok.Data;

@Data
public class CarMake {
//    id	id	int
//    主品牌ID	brand_id	int
//    主品牌名称	brand_name	varchar(500)
//    品牌名称	name	varchar(500)
//    其他名称	other_name	varchar(500)
//    英文名称	english_name	varchar(500)
//    厂商ID	manufacturer_id	int
//    所属国家	country_id	int
//    电话	phone	varchar(100)
//    网站	website	varchar(500)
//    logo url	logo_url	varchar(500)
//    Spell	spell	varchar(50)
//    介绍	introduction	varchar(1000)
//    是否激活	is_enabled	tinyint
//    是否删除	is_removed	tinyint
//    创建时间	create_time	int(11)
//    最后更新时间	update_time	int(11)
//    同步时间	sync_time	int(11)
    private int id;
    private String brandName;
    private String name;
    private String otherName;
    private String englishName;
    private int manufacturerId;
    private int countryId;
    private String phone;
    private String website;
    private String logoUrl;
    private String spell;
    private String introduction;
    private int isEnabled;
    private int isRemoved;
    private int createTime;
    private int updateTime;
    private int syncTime;
}
