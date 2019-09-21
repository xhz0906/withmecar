package com.qf.j1904.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageSendlog implements Serializable {
    private Long id;

    private Long messageId;

    private Integer sendTime;

    private Long toMid;

    private Integer received;

    private String receiveTime;

    private Byte viewed;

    private String viewTime;

    private Byte viewDetail;

    private String viewDetailTime;
}
