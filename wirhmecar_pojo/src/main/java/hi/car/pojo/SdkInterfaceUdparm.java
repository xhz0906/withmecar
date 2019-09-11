package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SdkInterfaceUdparm implements Serializable {
    private int id;
    private int activityId;
    private int interfaceId;
    private String name;
    private String parmName;
    private int dataType;
    private String description;
    private int productId;
}
