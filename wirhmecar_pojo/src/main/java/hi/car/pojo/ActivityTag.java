package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ActivityTag implements Serializable {
    private int id;
    private int activityId;
    private int tagId;
}
