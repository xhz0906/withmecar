package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SdkInterfaceType implements Serializable {
    private int id;
    private String typeId;
    private int interfaceCount;
}
