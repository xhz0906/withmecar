package com.qf.j1904.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {
    private Long id;

    private Byte type;

    private String link;

    private Integer isSchedule;

    private Integer scheduleTime;

    private Integer sendTime;

    private String content;
}
