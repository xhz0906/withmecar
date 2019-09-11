package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class ActivityCar implements Serializable {
    private int id;
    private int activityId;
    private int carId;
    private int enable;
}
