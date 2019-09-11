package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class ActivityLink implements Serializable {
    private int id;
    private int activityId;
    private int channlId;
    private String link;
}
