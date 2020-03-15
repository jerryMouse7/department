package com.qiu.department.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

@Data
public class Repair implements Serializable {
    private static final long serialVersionUID = -25039876845532711L;

    private Long id;
    /**
     * 报修人id
     */
    private Long userId;
    private String username;
    private String instituteName;

    private String major;
    /**
     * 学号
     */
    private String sno;
    /**
     * 房间号
     */
    private String room;
    /**
     * 损坏设备
     */
    private String device;
    /**
     * 原因
     */
    private String reason;
    /**
     * 0、未修理 1、修理中，-1、已修好
     */
    private Integer state;

    private Long departmentId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}