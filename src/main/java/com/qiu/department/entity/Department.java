package com.qiu.department.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Department implements Serializable {
    private static final long serialVersionUID = -45203381906501748L;
    
    private Long id;
    /**
    * 楼栋名称
    */
    private String departmentName;
    /**
    * 0、男生宿舍 1、女生宿舍
    */
    private Integer type;


}