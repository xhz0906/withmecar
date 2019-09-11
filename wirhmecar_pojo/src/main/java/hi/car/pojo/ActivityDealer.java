package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class ActivityDealer implements Serializable {
    private int id;
    private int activityId;
    private int dealerId;
    private String dealerProvince;
    private String dealerCity;
}
