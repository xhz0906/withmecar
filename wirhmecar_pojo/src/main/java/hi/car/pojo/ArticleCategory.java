package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleCategory implements Serializable {
//    id	int
    private int id;
//    name	varchar(100)
    private String name;
//    is_deleted	tinyint
    private int isDeleted;
//    sort_num	int
    private String sortNum;
//    create_time	int(11)
    private int createTime;
//    last_update_time	int(11)
    private int lastUpDateTime;


}
