package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SdkTemp implements Serializable {
    private int id;
    private int activityId;
    private String sdkPath;
    private int createTime;
    private String sdkName;
}
