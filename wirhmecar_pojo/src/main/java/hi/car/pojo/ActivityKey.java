package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class ActivityKey implements Serializable {
    private int id;
    private int activityId;
    private int createTime;
    private String kes;
}
