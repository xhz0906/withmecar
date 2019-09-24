package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActivityCategory implements Serializable {
    private int id;
    private String name;
    private int isDeleted;
    private Date createTime;
    private Date lastUpdateTime;
    private String useCount;
}
