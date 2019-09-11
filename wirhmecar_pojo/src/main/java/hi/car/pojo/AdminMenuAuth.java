package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminMenuAuth implements Serializable {
    private int id;
    private String controller;
    private String action;
    private String name;
    private String classname;
    private int status;
    private int sort;
    private int type;
    private int parentId;

}
