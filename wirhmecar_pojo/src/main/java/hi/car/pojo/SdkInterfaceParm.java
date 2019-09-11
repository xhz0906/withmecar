package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SdkInterfaceParm implements Serializable {
    private int id;
    private int interfaceId;
    private String name;
    private String parmName;
    private int dataType;
    private String description;
    private int isRequired;
    private int isCustom;
    private int isLogin;
    private int activityKey;
}
