package hi.car.pojo;

import lombok.Data;

@Data
public class CarBrand {
    /*id	int
    name	varchar(500)
    other_name	varchar(500)
    english_name	varchar(500)
    logo_url	varchar(500)
    logo_meaning	varchar(1000)
    first_char	varchar(5)
    spell	varchar(50)
    all_spell	varchar(50)
    name_spell	varchar(50)
    name_all_spell	varchar(50)
    introduction	varchar(1000)
    sale_status	tinyint
    is_enabled	tinyint
    is_removed	tinyint
    create_time	int(11)
    update_time	int(11)
    do_time	int(11)
    sync_time	int(11)*/
    private int id;//品牌id
    private String name;//主品牌名称
    private String otherName;//其他名称
    private String englishName;//英文名称
    private String logoUrl;//logo url
    private String logoMeaning;//logo含义
    private String firstChar;//首字母
    private String spell;//拼写
    private String allSpell;//所有拼写
    private String nameSpell;//名称拼写
    private String nameAllSpell;//所有名称拼写
    private String introduction;//介绍
    private int saleStatus;//在售状态
    private int isEnables;//是否激活
    private int isremoved;//是否删除
    private int createTime;//创建时间
    private int updateTime;//最后更新时间
    private int doTime;//
    private int sync_time;//同步时间

}
