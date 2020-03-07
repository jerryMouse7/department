package com.qiu.department.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = -19390109642662801L;
    
    private Long id;
    /**
    * 姓名
    */
    private String username;
    /**
    * 学号
    */
    private String sno;
    
    private String password;
    /**
    * 状态：0 正常 -1 注销
    */
    private Integer state;
    /**
    * 入住时间
    */
    private LocalDateTime createTime;
    /**
    * 电话号码
    */
    private String phone;
    /**
    * 0、管理员  1、学生
    */
    private Integer type;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 楼栋id
    */
    private Long departmentId;
    /**
    * 寝室名称
    */
    private Long dormitoryName;
    /**
    * 院系名称
    */
    private Long collegeName;


}