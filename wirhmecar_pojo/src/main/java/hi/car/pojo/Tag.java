package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tag implements Serializable {
    private int id;
    private String name;
    private int isDeleted;
    private String createTime;
    private String lastUpdateTime;
    private int clickCount;
    private int type;
}
