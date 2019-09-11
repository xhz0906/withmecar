package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class ActivityChannel implements Serializable {
    private int id;
    private String name;
    private int isDeleted;
    private int createTime;
    private int lastUpdateTime;
    private String useCount;
    private String sign;
}
