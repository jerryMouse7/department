package com.qiu.department.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

@Data
public class Complain implements Serializable {
    private static final long serialVersionUID = 981334121661749240L;
    
    private Long id;
    /**
    * 标题
    */
    private String title;
    /**
    * 内容
    */
    private String content;
    /**
    * 投诉人
    */
    private Long createBy;
    /**
    * 投诉时间
    */
    private LocalDateTime createTime;
    /**
    * 回复者
    */
    private String replyBy;
    /**
    * 回复内容
    */
    private String replyContent;
    /**
    * 回复时间
    */
    private LocalDateTime replyTime;
    /**
    * 投诉人姓名
    */
    private String username;
    
    private String departmentName;
    /**
    * 宿舍号
    */
    private String room;


}