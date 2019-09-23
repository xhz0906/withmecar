package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    private int id;

    private String name;

    private String description;

    private String service;

    private String createTime;

    private String updateTime;
}
