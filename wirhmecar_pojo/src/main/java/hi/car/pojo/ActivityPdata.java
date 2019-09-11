package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ActivityPdata implements Serializable {
    private int id;
    private int activityId;
    private int memberId;
    private String name;
    private String mobile;
    private int province;
    private String provinceName;
    private int city;
    private String cityName;
    private String remark;
    private String extendData;
    private String creatTime;
    private int brandId;
    private String brandName;
    private int makeId;
    private String makeName;
    private int modelId;
    private String modelName;
    private int carId;
    private String carName;
    private int dealerId;
    private int cahnnelId;
    private int state;
    private int stateUpdateUid;
    private int stateUpdateTime;
    private String visitorGuid;
    private String visitIp;
    private String dealerName;
}
