package com.qf.j1904.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    private Integer id;

    private String name;

    private String description;

    private String service;

    private Integer createTime;

    private Integer updateTime;
}
