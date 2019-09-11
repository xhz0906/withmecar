package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class AdminRole implements Serializable {
    private int id;
    private String name;
    private int deleted;
}
