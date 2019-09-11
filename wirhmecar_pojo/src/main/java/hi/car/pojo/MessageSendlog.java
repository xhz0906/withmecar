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

    private Integer receiveTime;

    private Byte viewed;

    private Integer viewTime;

    private Byte viewDetail;

    private Integer viewDetailTime;
}
