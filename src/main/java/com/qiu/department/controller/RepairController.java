package com.qiu.department.controller;

import com.qiu.department.entity.Repair;
import com.qiu.department.service.RepairService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("repair")
public class RepairController {
    /**
     * 服务对象
     */
    @Resource
    private RepairService repairService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Repair selectOne(Long id) {
        return this.repairService.queryById(id);
    }

}