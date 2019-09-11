package hi.car.pojo;

import lombok.Data;

@Data
public class CarImage {
  /*  id	id	int
    图片标题	img_title	varchar(500)
    图片类型	img_type	int
    图片URL	img_url	varchar(500)
    创建时间	create_time	int(11)
    最后更新时间	update_time	int(11)
    同步时间	sync_time	int(11)*/
    private int id;
    private String img_title;
    private int imgType;
    private String imgUrl;
    private int createTime;
    private int updateTime;
    private int syncTime;


}
