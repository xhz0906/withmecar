package hi.car.pojo;

import lombok.Data;

@Data
public class CarModelImage {
    /*id	id	int(11)
    车型ID	model_id	int(11)
    年款	year	varchar(500)
    图片URL	img_url	varchar(500)
    创建时间	create_time	int(11)
    最后更新时间	update_time	int(11)
    同步时间	sync_time	int(11)*/
    private int id;
    private int modelId;
    private String year;//车型年款
    private String imgUrl;
    private String createTime;//创建时间
    private String updateTime;//最后更新时间
    private String syncTime;//同步时间
}
