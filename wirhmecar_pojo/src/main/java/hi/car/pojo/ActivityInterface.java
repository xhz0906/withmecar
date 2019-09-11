package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class ActivityInterface implements Serializable {
    private int id;
    private int activityId;
    private int interfaceId;
    private int sdkId;
}
