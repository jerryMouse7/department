package com.qiu.department.controller;

import com.qiu.department.entity.Department;
import com.qiu.department.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("department")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;


}