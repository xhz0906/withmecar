package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SdkInterfaceInfo implements Serializable {
    private int id;
    private int activityId;
    private String carsId;
    private String activityKey;
    private String dealer;
}
