package com.qiu.department.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

@Data
public class Visitor implements Serializable {
    private static final long serialVersionUID = 747525601869827488L;
    
    private Long id;
    /**
    * 姓名
    */
    private String name;
    /**
    * 手机号
    */
    private String phone;
    /**
    * 家庭住址
    */
    private String address;
    /**
    * 来访房间
    */
    private String visitorRoom;
    /**
    * 来访缘由
    */
    private String reason;
    /**
    * 来访时间
    */
    private LocalDateTime visitorTime;

    private Long deparmentId;


}