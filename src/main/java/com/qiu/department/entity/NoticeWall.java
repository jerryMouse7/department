package com.qiu.department.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

@Data
public class NoticeWall implements Serializable {
    private static final long serialVersionUID = -42796257366537190L;
    
    private Long id;
    /**
    * 标题
    */
    private String title;
    /**
    * 正文
    */
    private String content;
    /**
    * 来源
    */
    private String source;
    /**
    * 创建人
    */
    private Long createBy;
    /**
    * 创建时间
    */
    private LocalDateTime createTime;


}