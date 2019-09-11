package com.qf.j1904.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OperateLog implements Serializable {
    private Long id;

    private Integer operateTime;

    private Integer operateUid;

    private String tableName;

    private String tableDisname;

    private Long dataId;

    private String operateDesc;
}
