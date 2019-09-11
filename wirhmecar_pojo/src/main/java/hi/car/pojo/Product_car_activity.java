package com.qf.j1904.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product_car_activity implements Serializable {
    private Integer id;

    private Integer productId;

    private Integer carId;

    private Integer activityId;
}
