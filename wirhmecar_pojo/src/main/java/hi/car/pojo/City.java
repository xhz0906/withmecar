package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class City implements Serializable {
    private int id;
    private int pid;
    private String cityname;
    private int type;
}
