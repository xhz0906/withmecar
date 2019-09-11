package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Area implements Serializable {
//    id	int(11)
    private int id;
    private String name;
//    name	varchar(64)
//    pid	int(11)
    private int pid;
//    areacode	varchar(64)
    private String areacode;

}
