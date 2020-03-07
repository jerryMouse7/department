package com.qiu.department.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Repair implements Serializable {
    private static final long serialVersionUID = -33314409622421074L;
    
    private Long id;
    /**
    * 报修人
    */
    private Long userId;
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


}